package swing;

import com.recognition.image.constants.Constants;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel {
  private JPanel rootPanel;
  private JPanel mainPanel;
  private JPanel buttonPanel;
  public static JButton startButton;
  public static JButton pauseButton;
  public static JButton testButton;
  public static JPanel webcamPanel;
  private JTabbedPane pages;
  private JPanel One;
  private JPanel Two;
  private Webcam webcam;


  public static void main(String[] args) {
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

    webcam = new Webcam();


  }


  private void createUIComponents() {
    mainPanel.setPreferredSize(new Dimension(320, 240));
    mainPanel.setBackground(Color.ORANGE);
    mainPanel.setBorder(new LineBorder(new Color(23, 175, 42), 5));

    startButton.setPreferredSize(new Dimension(100, 30));
    pauseButton.setPreferredSize(new Dimension(100, 30));

  }
}
