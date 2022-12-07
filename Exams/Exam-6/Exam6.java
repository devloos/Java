
/**
 * Author: Carlos Aguilera
 * Date: 12/06/22
 * ID: 1152562
 * Brief: This program tests the ability to hold contacts in memory.
 * It tests polymorphism, oop, text parsing and much more.
 * The progams main goal however is to hold contacts such as
 * Personal or Business Contacts.
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam6 {
  public static int EXIT = 6;
  public static int DEFAULT = -1;

  public static void menu() {
    System.out.print("----MENU----\n" +
        "1. Add a person contact\n" +
        "2. Add a professional contact\n" +
        "3. Search for contact\n" +
        "4. Delete Contact\n" +
        "5. Print Address Book\n" +
        "6. Exit\n" +
        "------------\n\n\n");
    System.out.println("Please enter a number (1-6): ");
  }

  // adding either personal or professional
  public static void addContact(String[] input, AddressBook book) throws InputMismatchException {
    // dont know if i like relying on length
    if (input.length == 5) {
      book.addContact(new PersonalContact(input[0], input[1], input[2], input[3], input[4]));
      return;
    }

    if (input.length == 6) {
      book.addContact(new ProfessionalContact(input[0], input[1], input[2], input[3], input[4], input[5]));
      return;
    }

    throw new InputMismatchException();
  }

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    AddressBook book = new AddressBook();

    int choice = DEFAULT;
    do {
      menu();
      try {
        choice = cin.nextInt();
        cin.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("YOU DID NOT ENTER AN INTEGER - TRY AGAIN!\n\n");
        cin.nextLine();
        continue;
      }

      switch (choice) {
        case 1: {
          System.out.println("Enter firstName lastName telephone email relation");
          try {
            String[] input = cin.nextLine().split(" ");
            addContact(input, book);
            System.out.println("Personal Contact Added!\n\n");
          } catch (InputMismatchException e) {
            System.out.println("Invalid Personal Contact Input Fields!\n\n");
          }
          break;
        }
        case 2: {
          System.out.println("Enter firstName lastName telephone email occupation company");
          try {
            String[] input = cin.nextLine().split(" ");
            addContact(input, book);
            System.out.println("Professional Contact Added!\n\n");
          } catch (InputMismatchException e) {
            System.out.println("Invalid Professional Contact Input Fields!\n\n");
          }
          break;
        }
        case 3: {
          System.out.println("Enter firstName lastName");
          String[] input = cin.nextLine().split(" ");
          if (input.length != 2) {
            System.out.println("Invalid search information\n\n");
            continue;
          }

          Contact contact = book.search(input[0], input[1]);

          if (contact == null) {
            System.out.println("Contact not found!\n\n");
            continue;
          }

          System.out.println("Contact found:");
          System.out.println(contact.toString());
          break;
        }
        case 4: {
          System.out.println("Enter firstName lastName");
          String[] input = cin.nextLine().split(" ");
          if (input.length != 2) {
            System.out.println("Invalid search information\n\n");
            continue;
          }

          Contact contact = book.search(input[0], input[1]);

          if (contact == null) {
            System.out.println("Contact not found!\n\n");
            continue;
          }

          if (book.deleteContact(contact)) {
            System.out.println("Contact Was Deleted\n\n");
          }
          break;
        }
        case 5: {
          book.printAddressBook();
          System.out.println("\n");
          break;
        }
        case 6: {
          System.out.println("Good Bye!");
          break;
        }
        default: {
          System.out.println("YOU DID NOT ENTER AN INTEGER BETWEEN 1 - 6. TRY AGAIN!\n\n");
          break;
        }
      }
    } while (choice != EXIT);

    cin.close();
  }

}

abstract class Contact {
  public Contact(String firstName, String lastName, String email, String phone) {
    firstName_ = firstName;
    lastName_ = lastName;
    email_ = email;
    phone_ = phone;
  }

  public void setFirstName(String firstName) {
    firstName_ = firstName;
  }

  public String getFirstName() {
    return firstName_;
  }

  public void setLastName(String lastName) {
    lastName_ = lastName;
  }

  public String getLastName() {
    return lastName_;
  }

  public void setEmail(String email) {
    email_ = email;
  }

  public String getEmail() {
    return email_;
  }

  public void setPhone(String phone) {
    phone_ = phone;
  }

  public String getPhone() {
    return phone_;
  }

  @Override
  public String toString() {
    StringBuilder strRepresentation = new StringBuilder();
    strRepresentation.append(firstName_ + " " + lastName_ + "\n");
    strRepresentation.append("T: " + phone_ + "\n");
    strRepresentation.append("E: " + email_ + "\n");
    return strRepresentation.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Contact)) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    Contact c = (Contact) obj;

    return c.firstName_.equals(firstName_) && c.lastName_.equals(lastName_);
  }

  private String firstName_;
  private String lastName_;
  private String email_;
  private String phone_;
}

class PersonalContact extends Contact {
  public PersonalContact(String firstName, String lastName, String email, String phone, String relation) {
    super(firstName, lastName, email, phone);
    relation_ = relation;
  }

  public void setRelation(String relation) {
    relation_ = relation;
  }

  public String getRelation() {
    return relation_;
  }

  @Override
  public String toString() {
    StringBuilder strRepresentation = new StringBuilder(super.toString());
    strRepresentation.append("R: " + relation_ + "\n");
    return strRepresentation.toString();
  }

  private String relation_;
}

class ProfessionalContact extends Contact {
  public ProfessionalContact(String firstName, String lastName, String email, String phone, String company,
      String occupation) {
    super(firstName, lastName, email, phone);
    company_ = company;
    occupation_ = occupation;
  }

  public void setCompany(String company) {
    company_ = company;
  }

  public String getCompany() {
    return company_;
  }

  public void setOccupation(String occupation) {
    occupation_ = occupation;
  }

  public String getOccupation() {
    return occupation_;
  }

  @Override
  public String toString() {
    StringBuilder strRepresentation = new StringBuilder(super.toString());
    strRepresentation.append("C: " + company_ + "\n");
    strRepresentation.append("O: " + occupation_ + "\n");
    return strRepresentation.toString();
  }

  private String company_;
  private String occupation_;
}

class AddressBook {
  public AddressBook() {
    contacts = new ArrayList<Contact>();
  }

  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  public Contact search(String firstName, String lastName) {
    for (Contact contact : contacts) {
      if (contact.getFirstName().toLowerCase().equals(firstName.toLowerCase())
          && contact.getLastName().toLowerCase().equals(lastName.toLowerCase())) {
        return contact;
      }
    }
    return null;
  }

  public boolean deleteContact(Contact contact) {
    if (contact == null) {
      return false;
    }

    return contacts.remove(contact);
  }

  public void printAddressBook() {
    System.out.println("--Address Book--");
    for (Contact contact : contacts) {
      System.out.println(contact.toString());
    }
    System.out.println("--End--");
  }

  private ArrayList<Contact> contacts;
}