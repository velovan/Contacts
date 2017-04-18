package sourceBook;

import java.io.*;
import java.nio.channels.SelectableChannel;

import javax.naming.directory.SearchControls;

import functionsBook.*;

public class Menu {

	private static boolean flag = false;
	private static BufferedReader reader;

	public Menu() {
		new ContactList();
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	private void printMainMenu() {
		System.out.println("What do you want?");
		System.out.println("[1] Add a new contact");
		System.out.println("[2] Find a contact");
		System.out.println("[3] View all contacts");
		System.out.println("[4] Delete all contacts");
		System.out.println("[0] Exit and save");
		System.out.println();
		System.out.print("Enter a number: ");
	}

	public void mainMenu() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bookList"))) {
			while (!flag) {
				printMainMenu();

				new Finder().setFlag(false);
				new Finder().setFoundContact(null);
				new Sort().setFlag(false);

				String selections = reader.readLine();
				switch (selections) {
				case "1": {
					new Creator().addContact();
					break;
				}
				case "2": {
					new Finder().findContact();
					break;
				}
				case "3": {
					new Sort().sortAllContacts();
					break;
				}
				case "4": {
					if (ContactList.getList().isEmpty()) {
						System.out.println("\nContact book is empty\n");
					}
					if (new Cheking().chekDelete()) {
						new Cleaner().deleteAllContacts();
					}
					break;
				}
				case "0": {
					oos.writeObject(new ContactList().getList());
					reader.close();
					flag = true;
					break;
				}
				default: {
					System.out.println("\n::Invalid input::\n");
					break;
				}
				}
			}
		} catch (IOException e) {
			System.err.println();
		}
	}

	/**
	 * @return the reader
	 */
	public static BufferedReader getReader() {
		return reader;
	}

}
