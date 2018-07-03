import java.util.ArrayList;

public class Library {

    private ArrayList<LibraryBook> libraryShelf = new ArrayList<>();
    private ArrayList<Patron> libraryPatrons = new ArrayList<>();

    private static String welcomeMessage = "*** Welcome to Library Manager 0.1 ***\n\n";
    private static String options = "Options: \n\n" +
            "1. Add a Patron\n" +
            "2. Remove a Patron.\n" +
            "3. Add a Library Book.\n" +
            "4. Remove a Library book.\n" +
            "5. See a list of current Patrons.\n" +
            "6. See a list of current Library books.\n" +
            "7. Search for a Library book or Patron.\n" +
            "8. Check out a Library Book.\n" +
            "9. Display all currently checked out Library books.\n" +
            "10. Exit.";

    public static void main(String[] args){

        System.out.println(welcomeMessage + options);

    }

}
