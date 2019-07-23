package swing;

import com.recognition.image.constants.Constants;
import org.opencv.core.Core;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
  private Graphics g;


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
    createUIComponents();
    webcam = new Webcam(startButton, pauseButton, testButton, webcamPanel, g);
  }


  private void createUIComponents() {
    mainPanel.setPreferredSize(new Dimension(320, 240));
//    mainPanel.setBackground(Color.ORANGE);
    mainPanel.setBorder(new LineBorder(new Color(23, 175, 42), 5));
    startButton.setPreferredSize(new Dimension(100, 30));
    pauseButton.setPreferredSize(new Dimension(100, 30));
  }
}
