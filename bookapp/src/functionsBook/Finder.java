package functionsBook;

import java.awt.print.Printable;
import java.io.IOException;

import sourceBook.Contact;
import sourceBook.ContactList;
import sourceBook.Menu;

public class Finder {

	private static Contact foundContact = null;
	private static boolean flag = false;

	private void printMenu() {
		System.out.println("[1] Search by first name");
		System.out.println("[2] Search by last name");
		System.out.println("[3] Search by phone number");
		System.out.println("[0] Back to main menu");
		System.out.println();
		System.out.print("Enter a number: ");
	}

	public void findContact() {
		try {
			while (!flag) {
				System.out.println();
				printMenu();

				String selection = Menu.getReader().readLine();
				switch (selection) {
				case "1":
					System.out.println();
					System.out.print("Enter a first name: ");
					String firstName = Menu.getReader().readLine();
					System.out.println();
					for (Contact c : ContactList.getList()) {
						if (c.getFirstName().equals(firstName)) {
						    System.out.println(c);
						    foundContact = c;
						    System.out.println();
						}
					}
					if (foundContact != null) {
						flag = true;
					}
					if (foundContact == null) {
						System.out.println("Contact not found!");
					}
					break;
				case "2":
					System.out.println();
					System.out.print("Enter a last name: ");
					String lastName = Menu.getReader().readLine();
					System.out.println();
					for (Contact c : ContactList.getList()) {
						if (c.getLastName().equals(lastName)) {
							System.out.println(c);
							foundContact = c;
							System.out.println();
						}
					}
					if (foundContact != null) {
						flag = true;
					}
					if (foundContact == null) {
						System.out.println("Contact not found!");
					}
					break;
				case "3":
					System.out.println();
					System.out.print("Enter a phone number: ");
					String phoneNumber = Menu.getReader().readLine();
					System.out.println();
					for (Contact c : ContactList.getList()) {
						if (c.getPhoneNumber().equals(phoneNumber)) {
							System.out.println(c);
							foundContact = c;
							System.out.println();
							new Editor().editContact();
						}
					}
					if (foundContact != null) {
						flag = true;
					}
					if (foundContact == null) {
						System.out.println("Contact not found!");
					}
					break;
				case "0":
					System.out.println();
					flag = true;
					break;
				default:
					System.out.println();
					System.out.println("Incorrect input");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Contact getFoundContact() {
		return foundContact;
	}

	public static void setFoundContact(Contact foundContact) {
		Finder.foundContact = foundContact;
	}

	public static void setFlag(boolean flag) {
		Finder.flag = flag;
	}
}
