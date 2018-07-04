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

    /**
     * Display the current Patrons.
     * Returns the empty String if no
     * Patrons are in the system
     *
     * @return String
     */
    public String displayPatrons(){

        for(Patron p : libraryPatrons){
            return p.toString();
        }
        return "";

    }

    /**
     * Display the current LibraryBooks.
     * Returns the empty String if no
     * LibraryBooks are in the system
     *
     * @return String
     */
    public String displayLibraryBooks(){

        for(LibraryBook b : libraryShelf){
            return b.toString();
        }
        return "";

    }

    /**
     * Check each LibraryBook in the system against
     * a String key.  If there is a match return true,
     * otherwise return false.
     *
     * @param key String
     * @return boolean
     */
    public boolean searchByBook(String key) {

        boolean result = false;
        for (LibraryBook b : libraryShelf) {

            if (b.getTitle().contains(key) || b.getAuthor().contains(key)) {
                result = true;
            }else{
                continue;
            }

        }

        return result;

    }

    /**
     * Check each Patron in the system against
     * a String key. If there is a match return true,
     * otherwise return false.
     *
     * @param key String
     * @return boolean
     */
    public boolean searchByPatron(String key){

        boolean result = false;
        for(Patron p : libraryPatrons){

            if(p.getFirstName().contains(key) || p.getLastName().contains(key)){
                result = true;
            }else{
                continue;
            }

        }

        return result;

    }

    public static void main(String[] args){

        System.out.println(welcomeMessage + options);

    }

}
