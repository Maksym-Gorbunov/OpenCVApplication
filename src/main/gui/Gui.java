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
  private JButton addContactButton2;
  private JButton printAllContactsButton2;
  private JButton deleteButton2;
  private JTextField nameTextField2;
  private JTextField phoneTextField2;
  private JTextField emailTextField2;
  private JTextField surnameTextField2;
  private JPanel contactsPanel2;
  private JComboBox contactsComboBox2;
  private JButton editButton2;
  private JButton saveButton2;

  private Page1 page1;
  private Page2 page2;

  public Gui() {
    super("Application");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(rootPanel);
    setLocationRelativeTo(this);
    setResizable(false);
    setVisible(true);

    page1 = new Page1(startButton1, pauseButton1, testButton1, webcamPanel1);
//    page2 = new Page2(addContactButton2, printAllContactsButton2, deleteButton2, nameTextField2, phoneTextField2, emailTextField2, surnameTextField2);
    page2 = new Page2(Gui.this);

  }


  // Getters & Setters
  public JTabbedPane getPagesPanel() {
    return pagesPanel;
  }

  public JPanel getPagePanel1() {
    return pagePanel1;
  }

  public JPanel getPagePanel2() {
    return pagePanel2;
  }

  public JPanel getPagePanel3() {
    return pagePanel3;
  }

  public JPanel getMainPanel1() {
    return mainPanel1;
  }

  public JPanel getButtonsPannel1() {
    return buttonsPannel1;
  }

  public JButton getStartButton1() {
    return startButton1;
  }

  public JButton getPauseButton1() {
    return pauseButton1;
  }

  public JButton getTestButton1() {
    return testButton1;
  }

  public JPanel getRootPanel() {
    return rootPanel;
  }

  public JPanel getWebcamPanel1() {
    return webcamPanel1;
  }

  public JPanel getLabelsPanel2() {
    return labelsPanel2;
  }

  public JPanel getFieldsPanel2() {
    return fieldsPanel2;
  }

  public JPanel getButtonsPanel2() {
    return buttonsPanel2;
  }

  public JLabel getNameLabel2() {
    return nameLabel2;
  }

  public JLabel getEmailLabel2() {
    return emailLabel2;
  }

  public JLabel getPhoneLabel2() {
    return phoneLabel2;
  }

  public JLabel getSurnameLabel2() {
    return surnameLabel2;
  }

  public JButton getAddContactButton2() {
    return addContactButton2;
  }

  public JButton getPrintAllContactsButton2() {
    return printAllContactsButton2;
  }

  public JButton getDeleteButton2() {
    return deleteButton2;
  }

  public JButton getEditButton2() {
    return editButton2;
  }

  public JButton getSaveButton2() {
    return saveButton2;
  }

  public JTextField getNameTextField2() {
    return nameTextField2;
  }

  public JTextField getPhoneTextField2() {
    return phoneTextField2;
  }

  public JTextField getEmailTextField2() {
    return emailTextField2;
  }

  public JTextField getSurnameTextField2() {
    return surnameTextField2;
  }

  public JPanel getContactsPanel2() {
    return contactsPanel2;
  }

  public JComboBox getContactsComboBox2() {
    return contactsComboBox2;
  }

  public Page1 getPage1() {
    return page1;
  }

  public Page2 getPage2() {
    return page2;
  }
}
