package webcam003;

import com.recognition.image.algoritm.FaceDetection;
import com.recognition.image.constants.Constants;
import com.recognition.image.gui.ImagePanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
  private static final long serialVersionUID = 1L;
  private JPanel panelWebCam;
  private JPanel panel;
  private JButton startBtn;
  private JButton pauseBtn;

  private ImagePanel imagePanel;
  private JFileChooser fileChooser;


  public UI() {
//    super(Constants.APPLICATION_NAME);
    setTitle("My Gui");
    setJMenuBar(createMenuBar());

    this.panel = new JPanel();
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    panel.setBackground(Color.ORANGE);


    this.panelWebCam = new JPanel();
    panelWebCam.setBackground(Color.BLUE);
    panelWebCam.setPreferredSize(new Dimension(320, 240));

    this.startBtn = new JButton("Start");
    this.pauseBtn = new JButton("Pause");

    this.getContentPane().add(panel);
    panel.add(panelWebCam, BorderLayout.CENTER);
    panel.add(startBtn, BorderLayout.PAGE_END);
    panel.add(pauseBtn, BorderLayout.PAGE_END);
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);


    startBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Start...");
        //JOptionPane.showMessageDialog(null, "Start...");
      }
    });

    pauseBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Pause...");
        //JOptionPane.showMessageDialog(null, "Pause...");
      }
    });
  }


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
}
