package functionsBook;

import sourceBook.Contact;
import sourceBook.ContactList;

public class DeleterContact {

	public void deleteContact() {

		for (Contact c : ContactList.getList()) {
			if (c.equals(Finder.getFoundContact())) {
				ContactList.getList().remove(c);
				System.out.println("Contact deleted");
				System.out.println();
			}
		}
	}

}
