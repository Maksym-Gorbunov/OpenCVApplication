package webcam003;

import com.recognition.image.constants.Constants;

import javax.swing.*;
import java.awt.*;

public class UI extends JFrame {
  private static final long serialVersionUID = 1L;
  private JPanel panel;
  private JButton startBtn;
  private JButton pauseBtn;


  public UI() {
    super(Constants.APPLICATION_NAME);

    this.panel = new JPanel();
    this.startBtn = new JButton();
    this.pauseBtn = new JButton();
    add(panel);
    add(startBtn);
    add(pauseBtn);
//    add(imagePanel, BorderLayout.CENTER);
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGTH);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(this);
  }
}
