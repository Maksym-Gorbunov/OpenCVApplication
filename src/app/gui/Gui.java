package app.gui;

import javax.swing.*;

import app.page1.Page1;
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


public class Gui extends JFrame {
  private static final long serialVersionUID = 1L;
  private JTabbedPane pagesPanel;
  private JPanel pagePanel1;
  private JPanel pagePanel2;
  private JPanel pagePanel3;
  private JPanel mainPanel1;
  private JPanel buttonsPannel1;
  private JButton startButton1;
  private JButton pauseButton1;
  private JButton testButton1;
  private JPanel rootPanel;
  private JPanel webcamPanel1;
  private Page1 page1;

  public Gui() {
    super("Application");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(rootPanel);
    setLocationRelativeTo(this);
    setResizable(false);
//    pack();
    setVisible(true);

    page1 = new Page1(startButton1, pauseButton1, testButton1, webcamPanel1);


  }




}
