package main.pages.page2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    addContaktButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = nameTextField2.getText();
        String surname = surnameTextField2.getText();
        String email = emailTextField2.getText();
        String phone = phoneTextField2.getText();
        // TODO: 7/25/2019 why add empty contact??? 
        if (!name.equals("") && !surname.equals("") && !email.equals("") && !phone.equals("")) {
          contactBook.getContacts().add(new Contact(name, surname, email, phone));
          System.out.println("New contact was added successfully!");
        } else {
          System.out.println("cant add empty fields");
        }
        clearAllTextFields();
      }
    });


    printAllContaktsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        contactBook.printAllContacts();
        System.out.println("Total: " + contactBook.getContacts().size());
      }
    });
  }

  public void clearAllTextFields() {
    nameTextField2.setText("");
    surnameTextField2.setText("");
    emailTextField2.setText("");
    phoneTextField2.setText("");
  }
}
