package functionsBook;

import sourceBook.ContactList;

public class Cleaner {

	public void deleteAllContacts() {
		System.out.println("Successfully cleared!");
		if (ContactList.getList().size() == 1) {
			System.out.println("1 contact was deleted");
		} else if (ContactList.getList().size() > 1) {
			System.out.println(ContactList.getList().size() + " contacts were deleted");
		}
		System.out.println();
		ContactList.getList().clear();
	}

}
