package webcam003;

import com.recognition.image.algoritm.FaceDetection;
import com.recognition.image.constants.Constants;
import com.recognition.image.gui.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
  private static final long serialVersionUID = 1L;
  private JPanel panel;
  private JButton startBtn;
  private JButton pauseBtn;

  private ImagePanel imagePanel;
  private JFileChooser fileChooser;


  public UI() {
    super(Constants.APPLICATION_NAME);
    setJMenuBar(createMenuBar());

    this.panel = new JPanel();
    this.startBtn = new JButton();
    this.pauseBtn = new JButton();

    this.imagePanel = new ImagePanel();
    this.fileChooser = new JFileChooser();

//    add(imagePanel, BorderLayout.CENTER);
    add(panel);
    add(startBtn);
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);


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
