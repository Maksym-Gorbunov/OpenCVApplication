package swing;

//import com.recognition.image.constants.Constants;
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.videoio.VideoCapture;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;


import com.recognition.image.constants.Constants;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;





public class App extends JPanel {
  private static final long serialVersionUID = 1L;
  private JPanel rootPanel;
  private JPanel mainPanel;
  private JPanel buttonPanel;
  private JButton startButton;
  private JButton pauseButton;
  private JButton testButton;
  private JPanel webcamPanel;
  private JTabbedPane pages;
  private JPanel One;
  private JPanel Two;
  private Webcam webcam;
  //  private Graphics g;
  boolean status = false;
  public Color defaultPanelColor;



  public static void main(String[] args) {
    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    JFrame frame = new JFrame("App");
    frame.setContentPane(new App().rootPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH));
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
  }


  public App() {
    test();
    createUIComponents();
    addListenersToPage1();

    this.defaultPanelColor = webcamPanel.getBackground();
    //    webcam = new Webcam(startButton, pauseButton, testButton, webcamPanel, g);
  }


  private void createUIComponents() {
    mainPanel.setPreferredSize(new Dimension(320, 240));
//    mainPanel.setBackground(Color.ORANGE);
    mainPanel.setBorder(new LineBorder(new Color(23, 175, 42), 5));
    startButton.setPreferredSize(new Dimension(100, 30));
    pauseButton.setPreferredSize(new Dimension(100, 30));
  }


  ////////////////////////////////////////////////////////////////////////////////////////
  // definitions

  private void addListenersToPage1() {
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Start...");
        webSource = new VideoCapture(0);
        myThread = new DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
        startButton.setEnabled(false);  //start button
        pauseButton.setEnabled(true);  // stop button
      }
    });

    pauseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Pause...");
        myThread.runnable = false;
        pauseButton.setEnabled(false);
        startButton.setEnabled(true);
        webSource.release();
      }
    });

    testButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        status = !status;
        if (status) {
          webcamPanel.setBackground(Color.ORANGE);
        } else {
          webcamPanel.setBackground(defaultPanelColor);
        }
        JOptionPane.showMessageDialog(null, "Test...", "Test title", JOptionPane.QUESTION_MESSAGE);
      }
    });

  }


  private DaemonThread myThread = null;
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
              Graphics g = webcamPanel.getGraphics();
              if (g.drawImage(buff, 0, 0, 320, 240, 0, 0, buff.getWidth(), buff.getHeight(), null))
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


  public void test() {
//    final JPanel jPanelCamera = new JPanel();

////    jTabbedPane1.addTab("Camera", jPanelCamera);
//
//    Webcam webcam = Webcam.getDefault();
//    webcam.setViewSize(WebcamResolution.VGA.getSize());
//
//    WebcamPanel webcamPanel = new WebcamPanel(webcam);
//    webcamPanel.setFPSDisplayed(true);
//    webcamPanel.setDisplayDebugInfo(true);
//    webcamPanel.setImageSizeDisplayed(true);
//    webcamPanel.setMirrored(true);
//
//    jPanelCamera.add(webcamPanel);
//    jPanelCamera.getParent().revalidate();

    System.out.println("Camera OK");
  }
}
