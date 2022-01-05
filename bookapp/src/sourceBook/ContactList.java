package sourceBook;

import java.io.*;
import java.util.LinkedList;

import javax.imageio.stream.FileImageInputStream;

public class ContactList {

	private static LinkedList<Contact> list;

	public ContactList() {
		File file = new File("bookList");
		if (!file.exists()) {
			list = new LinkedList<Contact>();
		} else {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				try {
					list = (LinkedList<Contact>) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println();
			}
		}
	}

	/**
	 * @return the list
	 */
	public static LinkedList<Contact> getList() {
	  return list;
	}

}
