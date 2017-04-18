package sourceBook;

import java.util.Comparator;
 
public class FirstNameComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact a, Contact b) {
        return a.getFirstName().compareTo(b.getFirstName());
    }

}
 
