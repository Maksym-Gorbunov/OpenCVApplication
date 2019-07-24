package main.gui;

import javax.swing.*;

import main.pages.page1.Page1;


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
