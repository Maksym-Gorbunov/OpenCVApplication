package main.pages.page2;

import main.gui.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page2 {
  private static final long serialVersionUID = 1L;

  private JButton addContactButton;
  private JButton printAllContactsButton;
  private JButton deleteButton;
  private JButton editButton;
  private JButton saveButton;
  private JTextField nameTextField;
  private JTextField phoneTextField;
  private JTextField emailTextField;
  private JTextField surnameTextField;
  private JComboBox<Contact> contactsComboBox;

  private ContactBook contactBook = new ContactBook();
  private Gui gui;

  // Constructor
  public Page2(final Gui gui) {
    this.gui = gui;
    this.nameTextField = gui.getNameTextField2();
    this.surnameTextField = gui.getSurnameTextField2();
    this.phoneTextField = gui.getPhoneTextField2();
    this.emailTextField = gui.getEmailTextField2();
    this.addContactButton = gui.getAddContactButton2();
    this.editButton = gui.getEditButton2();
    this.saveButton = gui.getSaveButton2();
    this.printAllContactsButton = gui.getPrintAllContactsButton2();
    this.deleteButton = gui.getDeleteButton2();
    this.contactsComboBox = gui.getContactsComboBox2();

    dynamicAddContactButton();
    dynamicRemoveContactButton();
    dynamicEditButton();

    addListeners();

    contactBook.add(new Contact("Max", "Fry", "max@mail.com", "0766533"));
    contactBook.add(new Contact("Bob", "Person", "bob@mail.com", "0765013"));
    contactBook.getContacts().stream().forEach(c -> contactsComboBox.addItem(c));
    //contactsComboBox.setSelectedIndex(0);
  }

  // Add elements listeners
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

  // Clear all text fields
  public void clearAllTextFields() {
    nameTextField.setText("");
    surnameTextField.setText("");
    emailTextField.setText("");
    phoneTextField.setText("");
  }

  // Delete button dynamic start
  private void dynamicRemoveContactButton() {
    this.deleteButton.setEnabled(false);
    new Thread(removeTarget).start();
    contactsComboBox.addActionListener(removeActionListener);
  }

  final ActionListener removeActionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("Enable")) {
        deleteButton.setEnabled(true);
      } else if (e.getActionCommand().equalsIgnoreCase("Disable")) {
        deleteButton.setEnabled(false);
      }
    }
  };

  final Runnable removeTarget = new Runnable() {
    public void run() {
      while (true) {
        final ActionListener[] listeners = contactsComboBox.getActionListeners();
        for (ActionListener listener : listeners) {
          if ((contactsComboBox.getItemCount() > 0)) {
            final ActionEvent event = new ActionEvent(contactsComboBox, 1, "Enable");
            listener.actionPerformed(event);
          } else {
            final ActionEvent event = new ActionEvent(contactsComboBox, 1, "Disable");
            listener.actionPerformed(event);
          }
        }
      }
    }
  };
  // Delete button dynamic end

  // Add button dynamic start
  private void dynamicAddContactButton() {
    this.addContactButton.setEnabled(false);
    new Thread(addTarget).start();
    nameTextField.addActionListener(addActionListener);
  }

  final ActionListener addActionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("Enable")) {
        addContactButton.setEnabled(true);
      } else if (e.getActionCommand().equalsIgnoreCase("Disable")) {
        addContactButton.setEnabled(false);
      }
    }
  };

  final Runnable addTarget = new Runnable() {
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
  // Add button dynamic end

  // Edit button dynamic start
  private void dynamicEditButton() {
    this.editButton.setEnabled(false);
    new Thread(editTarget).start();
    contactsComboBox.addActionListener(editActionListener);
  }

  final ActionListener editActionListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      if (e.getActionCommand().equalsIgnoreCase("Enable")) {
        editButton.setEnabled(true);
      } else if (e.getActionCommand().equalsIgnoreCase("Disable")) {
        editButton.setEnabled(false);
      }
    }
  };

  final Runnable editTarget = new Runnable() {
    public void run() {
      while (true) {
        final ActionListener[] listeners = contactsComboBox.getActionListeners();
        for (ActionListener listener : listeners) {
          if (contactsComboBox.getItemCount() > 0) {
            final ActionEvent event = new ActionEvent(contactsComboBox, 1, "Enable");
            listener.actionPerformed(event);
          } else {
            final ActionEvent event = new ActionEvent(contactsComboBox, 1, "Disable");
            listener.actionPerformed(event);
          }
        }
      }
    }
  };
  // Edit button dynamic end
}
