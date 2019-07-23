package swing;

import com.recognition.image.constants.Constants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel {
  private JPanel rootPanel;
  private JPanel webcamPanel;
  private JPanel buttonPanel;
  private JButton startButton;
  private JButton pauseButton;
  private JButton testButton;


  public static void main(String[] args) {
    JFrame frame = new JFrame("App");
    frame.setContentPane(new App().rootPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public App() {
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Start...");
      }
    });
    pauseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Pause...");
      }
    });
    testButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Test...", "Test title", JOptionPane.QUESTION_MESSAGE);
      }
    });
  }
}
