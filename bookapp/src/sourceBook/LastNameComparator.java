package sourceBook;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact a, Contact b) {
        return a.getLastName().compareTo(b.getLastName());
    }
}
