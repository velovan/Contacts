package functionsBook;

import java.io.IOException;
import java.io.InvalidObjectException;

import sourceBook.Menu;

public class Cheking {

	private boolean chek = false;

	private void printMenu() {
		System.out.println();
		System.out.println("You sure that you want to do it?");
		System.out.println("[Y]es");
		System.out.println("[N]o");
		System.out.println();
	}

	public boolean chekDelete() {
		try {
			while (true) {
				printMenu();
				String selections = Menu.getReader().readLine();
				if (selections.equalsIgnoreCase("Y")) {
					chek = true;
					break;
				}
				if (selections.equalsIgnoreCase("N")) {
					chek = false;
					break;
				}
				if (!selections.equalsIgnoreCase("Y") && !selections.equalsIgnoreCase("N")) {
					System.out.println("Invalid input try again");
				}
			}
		} catch (IOException e) {
			System.err.println();
		}
		
		return chek;
	}

}
