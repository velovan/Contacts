package functionsBook;

import java.io.IOException;

import sourceBook.Menu;

public class Editor {

    private void printMenu() {
        System.out.println("[1] Edit a contact");
        System.out.println("[2] Delete a contact");
        System.out.println("[0] Back to main menu");
        System.out.println();
        System.out.print("Enter number: ");
    }

    public void editContact() {
        
        printMenu();
        try {
            String selection = Menu.getReader().readLine();
            switch (selection) {
                case "1":
                    new EditorContact().edit();
                    break;
                case "2":
                    if (new Cheking().chekDelete()) {
                        new DeleterContact().deleteContact();
                    }
                    break;
                case "0":
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Incorrect input");
                    break;
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
