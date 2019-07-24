package webcam003;

import com.recognition.image.constants.Constants;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class UI extends JFrame {
  private static final long serialVersionUID = 1L;
  private JPanel panelWebCam;
  private JPanel camera;
  private JButton startBtn;
  private JButton pauseBtn;
  private JTabbedPane tabbedPane1;
  private JPanel page1;
  private JPanel page2;
  private JPanel mainPanel;
  private JPanel buttonsPannel;

  public UI() {
    super(Constants.APPLICATION_NAME);
    initComponents();
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);

    startBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Start...");
        webSource = new VideoCapture(0);
        myThread = new UI.DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        startBtn.setEnabled(false);  //start button
        pauseBtn.setEnabled(true);  // stop button
      }
    });

    pauseBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Pause...");
        myThread.runnable = false;
        pauseBtn.setEnabled(false);
        startBtn.setEnabled(true);
        webSource.release();
      }
    });
  }


  //Initialize gui components
  private void initComponents() {
    setJMenuBar(createMenuBar());

    this.camera = new JPanel();
    camera.setBorder(new EmptyBorder(10, 10, 10, 10));
    camera.setBackground(Color.ORANGE);

    this.panelWebCam = new JPanel();
    panelWebCam.setBackground(Color.BLUE);
    panelWebCam.setPreferredSize(new Dimension(320, 240));

    this.startBtn = new JButton("Start");
    this.pauseBtn = new JButton("Pause");
    this.setContentPane(camera);
    //this.getContentPane().add(camera);
    camera.setPreferredSize(new Dimension(320, 240));
    camera.add(panelWebCam, BorderLayout.CENTER);
    camera.add(startBtn, BorderLayout.PAGE_END);
    camera.add(pauseBtn, BorderLayout.PAGE_END);
    //this.pack();
  }


  // Create menu bar
  public JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem loadMenuItem = new JMenuItem("Load image");
    JMenuItem detectMenuItem = new JMenuItem("Detect faces");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    fileMenu.add(loadMenuItem);
    fileMenu.add(detectMenuItem);
    fileMenu.add(exitMenuItem);
    JMenu aboutMenu = new JMenu("About");
    JMenu helpMenu = new JMenu("Help");
    menuBar.add(fileMenu);
    menuBar.add(aboutMenu);
    menuBar.add(helpMenu);
    return menuBar;
  }


  // definitions
  private UI.DaemonThread myThread = null;
  int count = 0;
  VideoCapture webSource = null;
  Mat frame = new Mat();
  MatOfByte mem = new MatOfByte();


  // class DeamonThread
  class DaemonThread implements Runnable {
    protected volatile boolean runnable = false;

    @Override
    public void run() {
      synchronized (this) {
        while (runnable) {
          if (webSource.grab()) {
            try {
              webSource.retrieve(frame);
              Imgcodecs.imencode(".bmp", frame, mem);
              BufferedImage buff = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
              Graphics g = camera.getGraphics();
              if (g.drawImage(buff, 100, 50, 320 + 100, 240 + 50, 100, 0, buff.getWidth(), buff.getHeight(), null))
//              if (g.drawImage(buff, 0, 0, getWidth()/2, getHeight() - 150, 0, 0, buff.getWidth(), buff.getHeight(), null))
                if (runnable == false) {
                  System.out.println("Going to wait()");
                  this.wait();
                }
            } catch (Exception e) {
              System.out.println("Error");
            }
          }
        }
      }
    }
  }
}
