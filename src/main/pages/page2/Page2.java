package main.pages.page2;

import javax.swing.*;

public class Page2 {
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
  private ContactBook contactBook = new ContactBook();


  public Page2(JButton addContaktButton, JButton printAllContaktsButton, JButton testButton2, JTextField nameTextField2, JTextField phoneTextField2, JTextField emailTextField2, JTextField surnameTextField2) {
    this.addContaktButton = addContaktButton;
    this.printAllContaktsButton = printAllContaktsButton;
    this.testButton2 = testButton2;
    this.nameTextField2 = nameTextField2;
    this.phoneTextField2 = phoneTextField2;
    this.emailTextField2 = emailTextField2;
    this.surnameTextField2 = surnameTextField2;


  }
}
