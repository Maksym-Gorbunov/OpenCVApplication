package main.pages.page2;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
  private List<Contact> contacts = new ArrayList<>();

  public void addContact(Contact contact) {
    contacts.add(contact);
    System.out.println("New contact was added successfully!");
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void printAllContacts() {
    for (Contact contact : contacts) {
      System.out.println(contact);
    }
  }
}
