package functionsBook;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sourceBook.Contact;
import sourceBook.ContactList;
import sourceBook.Menu;

public class EditorContact {

	private static boolean flag = false;

	private void printMenu() {
		System.out.println();
		System.out.println("[1] Edit a first name");
		System.out.println("[2] Edit a last name");
		System.out.println("[3] Edit a phone number");
		System.out.println("[0] Back to main menu");
		System.out.println();
		System.out.print("Enter number: ");
	}

	public void edit() {
		if (ContactList.getList().isEmpty()) {
			System.out.println("\n::Contact book is empty::\n");
		} else {
			try {
				while (!flag) {
					printMenu();
					String selections = Menu.getReader().readLine();
					switch (selections) {
					case "1": {
						System.out.println("Enter new First name: ");
						String firstName = Menu.getReader().readLine();
						for (Contact c : ContactList.getList()) {
							if (c.equals(Finder.getFoundContact())) {
							        c.setFirstName(firstName);
							}
						}
						break;
					}
					case "2": {
						System.out.println("Enter new Last name:");
						String lastName = Menu.getReader().readLine();
						for (Contact c : ContactList.getList()) {
							if (c.equals(Finder.getFoundContact())) {
								c.setLastName(lastName);
							}
						}
						break;
					}
					case "3": {
						System.out.println("Enter new Phone number: ");
						String phoneNumber = "";
						while (phoneNumber.equals("")) {
							phoneNumber = Menu.getReader().readLine();
							if (phoneNumber.equals("")) {
								System.out.println("Failed mast be filled");
							}
							for (Contact c : ContactList.getList()) {
								if (c.getPhoneNumber().equals(phoneNumber)) {
									phoneNumber = "";
									System.out.println("\nThis phone number already exist, enter another number: ");
								}
							}
						}
						for (Contact c : ContactList.getList()) {
							if (c.equals(Finder.getFoundContact())) {
								c.setPhoneNumber(phoneNumber);
							}
						}
						break;
					}
					case "0": {
						flag = true;
						break;
					}
					default: {
						System.out.println("\nIncorrect input\n");
						break;
					}
					}
				}
			} catch (IOException e) {
				System.err.println();
			}
		}
	}

	/**
	 * @return the flag
	 */
	public static boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag
	 *            the flag to set
	 */
	public static void setFlag(boolean flag) {
		EditorContact.flag = flag;
	}

}
