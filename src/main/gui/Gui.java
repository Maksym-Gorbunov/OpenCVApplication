package main.gui;

import javax.swing.*;

import main.pages.page1.Page1;
import main.pages.page2.Page2;


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

  private JPanel labelsPanel2;
  private JPanel fieldsPanel2;
  private JPanel buttonsPanel2;
  private JLabel nameLabel2;
  private JLabel emailLabel2;
  private JLabel phoneLabel2;
  private JLabel surnameLabel2;
  private JButton addContaktButton;
  private JButton printAllContaktsButton;
  private JButton testButton2;
  private JTextField nameTextField2;
  private JTextField phoneTextField2;
  private JTextField emailTextField2;
  private JTextField surnameTextField2;
  private Page1 page1;
  private Page2 page2;

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
    page2 = new Page2();


  }




}
