package functionsBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sourceBook.Contact;
import sourceBook.ContactList;
import sourceBook.LastNameComparator;
import sourceBook.Menu;

public class Creator {

	public void addContact() {
		try {
			String firstName = "";
			String lastName = "";
			String phoneNumber = "";

			while (firstName.equals("")) {
				System.out.println("Enter first name:\n");
				firstName = Menu.getReader().readLine();
				if (firstName.equals("")) {
					System.out.println("Failed mast be filled\n");
				}
			}
			while (lastName.equals("")) {
				System.out.println("Enter last name:\n");
				lastName = Menu.getReader().readLine();
				if (lastName.equals("")) {
					System.out.println("Failed mast be filled\n");
				}
			}
			while (phoneNumber.equals("")) {
				System.out.println("Enter phone number: \n");
				phoneNumber = Menu.getReader().readLine();
				if (phoneNumber.equals("")) {
					System.out.println("Failed mast be filled\n");
				}
				for (Contact c : ContactList.getList()) {
					if (c.getPhoneNumber().equals(phoneNumber)) {
						phoneNumber = "";
						System.out.println("This phone number already exist !!!");
					}
				}
			}
			System.out.println();
			ContactList.getList().add(new Contact(firstName, lastName, phoneNumber));
			System.out.println();
		} catch (IOException e) {
			System.err.println();
		}
	}

}
