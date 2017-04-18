package functionsBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collectors;

import sourceBook.*;

public class Sort {

	private static boolean flag = false;

	private void printMenu() {
		System.out.println("[1] Sort by first name");
		System.out.println("[2] Sort by last name");
		System.out.println("[3] Without sorting");
		System.out.println("[0] Back to main menu");
		System.out.println();
		System.out.print("Enter a number: ");
	}

	public void sortAllContacts() {
		if (ContactList.getList().isEmpty()) {
			System.out.println("\n::Contact book is empty::\n");
		} else {
			try {
				while (!flag) {
					printMenu();
					String selections = Menu.getReader().readLine();
					switch (selections) {
					case "1": {
						Collections.sort(ContactList.getList(), new FirstNameComparator());
						for (Contact c : ContactList.getList()) {
							System.out.println();
							System.out.println(c);
							System.out.println();
						}
						break;
					}
					case "2": {
						Collections.sort(ContactList.getList(), new LastNameComparator());
						for (Contact c : ContactList.getList()) {
							System.out.println();
							System.out.println(c);
							System.out.println();
						}
						break;
					}
					case "3": {
						for (Contact c : ContactList.getList()) {
							System.out.println();
							System.out.println(c);
							System.out.println();
						}
						break;
					}
					case "0": {
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
		Sort.flag = flag;
	}

}
