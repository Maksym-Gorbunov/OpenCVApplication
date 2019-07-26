package main.pages.page2;

import main.gui.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page2 {
  private static final long serialVersionUID = 1L;

  //  private JPanel labelsPanel;
//  private JPanel fieldsPanel;
//  private JPanel buttonsPanel;
//  private JLabel nameLabel;
//  private JLabel emailLabel;
//  private JLabel phoneLabel;
//  private JLabel surnameLabel;
  private JButton addContactButton;
  private JButton printAllContactsButton;
  private JButton deleteButton;
  private JTextField nameTextField;
  private JTextField phoneTextField;
  private JTextField emailTextField;
  private JTextField surnameTextField;
  private JComboBox<Contact> contactsComboBox;

  private ContactBook contactBook = new ContactBook();
  private Gui gui;

  public Page2(final Gui gui) {
    this.gui = gui;
    this.nameTextField = gui.getNameTextField2();
    this.surnameTextField = gui.getSurnameTextField2();
    this.phoneTextField = gui.getPhoneTextField2();
    this.emailTextField = gui.getEmailTextField2();
    this.addContactButton = gui.getAddContactButton2();
    this.printAllContactsButton = gui.getPrintAllContactsButton2();
    this.deleteButton = gui.getDeleteButton2();
    this.contactsComboBox = gui.getContactsComboBox2();

    dynamicAddContactButton();
    addListeners();


    contactBook.add(new Contact("Max", "Fry", "max@mail.com", "0766533"));
    contactBook.add(new Contact("Bob", "Person", "bob@mail.com", "0765013"));
    contactBook.getContacts().stream().forEach(c -> contactsComboBox.addItem(c));
    //contactsComboBox.setSelectedIndex(0);


  }

  private void dynamicAddContactButton() {
    this.addContactButton.setEnabled(false);
    new Thread(target).start();
    nameTextField.addActionListener(actionListener);

  }

  private void addListeners() {
    addContactButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();
        if (!name.equals("") && !surname.equals("") && !email.equals("") && !phone.equals("")) {
          Contact contact = new Contact(name, surname, email, phone);
          contactsComboBox.addItem(contact);
          contactBook.add(contact);
          System.out.println("New contact was added successfully!");
        }
        clearAllTextFields();
      }
    });

    printAllContactsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        contactBook.printAllContacts();
        System.out.println("Total: " + contactBook.getContacts().size());
      }
    });

    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (contactsComboBox.getItemCount() > 0) {
          contactBook.remove(contactsComboBox.getSelectedIndex());
          contactsComboBox.removeItem(contactsComboBox.getSelectedItem());
          System.out.println("Contact was successfully removed!");
        }
      }
    });
  }

  // clear all text fields
  public void clearAllTextFields() {
    nameTextField.setText("");
    surnameTextField.setText("");
    emailTextField.setText("");
    phoneTextField.setText("");
  }

  // add button dynamic start
  final ActionListener actionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("Enable")) {
        addContactButton.setEnabled(true);
      } else if (e.getActionCommand().equalsIgnoreCase("Disable")) {
        addContactButton.setEnabled(false);
      }
    }
  };

  final Runnable target = new Runnable() {
    public void run() {
      while (true) {
        final ActionListener[] listeners = nameTextField.getActionListeners();
        for (ActionListener listener : listeners) {
          if ((nameTextField.getText().trim().length() > 0)
                  && (surnameTextField.getText().trim().length() > 0)
                  && (emailTextField.getText().trim().length() > 0)
                  && (phoneTextField.getText().trim().length() > 0)) {
            final ActionEvent event = new ActionEvent(nameTextField, 1, "Enable");
            listener.actionPerformed(event);
          } else {
            final ActionEvent event = new ActionEvent(nameTextField, 1, "Disable");
            listener.actionPerformed(event);
          }
        }
      }
    }
  };
  // add button dynamic end
}
