import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Library class containing the main method.
 *
 * @author Wyatt Hoodes
 */
public class Library {

    private static ArrayList<LibraryBook> libraryShelf = new ArrayList<>();
    private static ArrayList<Patron> libraryPatrons = new ArrayList<>();

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
    
    private static String enterChoice = "\nPlease enter a corresponding number from the option list " +
            "(0 for options): ";

    /*
    In case the number of options available changes
    these variables will appear in the user input loop
    guards in the main method.
     */
    private static int lowOption = 0;
    private static int highOption = 10;

    /**
     * Display the current Patrons.
     *
     */
    private static void displayPatrons() {
        //Simple way to allow userChoice from the ArrayList//
        for (int i = 0; i < libraryPatrons.size(); i++) {
            System.out.print("\nID: " + i + ". " + libraryPatrons.get(i).toString() + "\n");
        }
    }

    /**
     * Display the current LibraryBooks.
     *
     */
    private static void displayLibraryBooks() {       
        //Just like displayPatrons//
        for (int i = 0; i < libraryShelf.size(); i++) {
            System.out.print("\nID: " + i + ". " + libraryShelf.get(i).toString() + "\n");
        }
    }

    /**
     * Check each LibraryBook in the system against
     * a String key.  Return an ArrayList, either empty
     * or non-empty.
     *
     * @param key String
     * @return ArrayList<LibraryBook>
     */
    public static ArrayList<LibraryBook> searchByBook(String key) {
        //Make an ArrayList of all the matching results//
        ArrayList<LibraryBook> results = new ArrayList<>();

        //Not a case sensitive search//
        for (LibraryBook b : libraryShelf) {
            if (b.getTitle().toLowerCase().contains(key.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(key.toLowerCase())) {

                results.add(b);
            }
        }
        return results;
    }

    /**
     * Check each Patron in the system against
     * a String key. Return an ArrayList, either empty
     * or non-empty.
     *
     * @param key String
     * @return ArrayList<Patron>
     */
    public static ArrayList<Patron> searchByPatron(String key) {
        //Make an ArrayList of all the matching results//
        ArrayList<Patron> results = new ArrayList<>();

        //Not a case sensitive search//
        for(Patron p : libraryPatrons){
            if(p.getFirstName().toLowerCase().contains(key.toLowerCase())
                    || p.getLastName().toLowerCase().contains(key.toLowerCase())){

                results.add(p);
            }
        }
        return results;
    }

    /**
     * Display all checked out books
     *
     */
    private static boolean displayCheckedOutBooks() {
        //Added a boolean in case there are no books checked out//
        boolean result = false;

        for(int i = 0; i < libraryShelf.size(); i++) {
            if(libraryShelf.get(i).getCheckedOut()) {
                result = true;  //There are books checked out//
                System.out.println(libraryShelf.get(i).toString());
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(welcomeMessage + options);

        int userChoice = -1; //Defaulted
        boolean userInputLoopGuard;

        //Independent inputs makes things easier//
        Scanner menuOptionInput = new Scanner(System.in);   //For user input
        Scanner createModifyInput = new Scanner(System.in); //For user create / modify
        Scanner searchKeyInput = new Scanner(System.in);    //For user searches

        //Loop the program until the user enters highOption//
        while(userChoice != highOption) {

            try {
                userInputLoopGuard = false;
                //Loop to ensure correct initial input//
                while (!userInputLoopGuard) {

                    System.out.print(enterChoice);
                    userChoice = menuOptionInput.nextInt();

                    if (userChoice >= lowOption && userChoice <= highOption) {
                        userInputLoopGuard = true;
                    } else {
                        System.out.println();
                    }

                }

                //For displaying the options//
                if(userChoice == 0) {
                    System.out.println(options);
                }

                //Add a patron//
                if (userChoice == 1) {
                    
                    String firstName;
                    String lastName;
                    System.out.print("Enter first name: ");
                    firstName = createModifyInput.nextLine();
                    System.out.print("Enter last name: ");
                    lastName = createModifyInput.nextLine();
                    Patron patron = new Patron(firstName, lastName);
                    libraryPatrons.add(patron);

                //Remove a patron//
                }else if(userChoice == 2) {
                    
                    //Need patrons in the system//
                    if(!libraryPatrons.isEmpty()) {

                        System.out.println();
                        displayPatrons();
                        System.out.print("Select the patron id: ");
                        userChoice = menuOptionInput.nextInt();
                        libraryPatrons.remove(userChoice);

                    }else{
                        System.out.println("There are no Library patrons.");
                    }

                //Add a LibraryBook//
                }else if(userChoice == 3) {
                    
                    String title;
                    String author;
                    System.out.print("Enter the title: ");
                    title = createModifyInput.nextLine();
                    System.out.print("Enter the author: ");
                    author = createModifyInput.nextLine();
                    LibraryBook b = new LibraryBook(title, author);
                    libraryShelf.add(b);

                //Remove a Library Book//
                }else if(userChoice == 4) {

                    //Need books on the shelf//
                    if(!libraryShelf.isEmpty()) {

                        System.out.println();
                        displayLibraryBooks();
                        System.out.print("\nSelect the Library Book id: ");
                        userChoice = menuOptionInput.nextInt();
                        libraryShelf.remove(userChoice);

                    }else{
                        System.out.println("The library shelf is empty.");
                    }


                //Display all patrons//
                }else if(userChoice == 5) {

                    if(libraryPatrons.isEmpty()) {
                        System.out.println("No patrons are currently in the system.");
                    }else {
                        displayPatrons();
                    }

                //Display all LibraryBooks//
                }else if(userChoice == 6) {

                    if(libraryShelf.isEmpty()) {
                        System.out.println("No books are currently in the system.");
                    }else {
                        System.lineSeparator();
                        displayLibraryBooks();
                    }

                //Search by Patron or Library Book//
                }else if(userChoice == 7) {

                    String key;
                    System.out.print("Enter \"0\" for Patron and \"1\" for Library Book: ");
                    userChoice = menuOptionInput.nextInt();
                    System.out.print("Enter the search key: ");
                    key = searchKeyInput.nextLine();

                    //Patron search//
                    if(userChoice == 0) {

                        ArrayList<Patron> results = searchByPatron(key);
                        for(Patron p : results) {
                            System.out.println(p.toString());
                        }

                    //Library book search//
                    }else {

                        ArrayList<LibraryBook> results = searchByBook(key);
                        for(LibraryBook b : results) {
                            System.out.println(b.toString());
                        }
                    }

                //Check out a book//
                }else if(userChoice == 8) {

                    if(libraryPatrons.isEmpty()) {
                        System.out.println("No patrons are in the system.");
                    }else if(libraryShelf.isEmpty()) {
                        System.out.println("No library books are in the system.");
                    }else {

                        int patronId;
                        int bookId;

                        System.lineSeparator();
                        displayPatrons();
                        System.out.print("\nEnter a patron id: ");
                        System.lineSeparator();
                        patronId = menuOptionInput.nextInt();
                        displayLibraryBooks();
                        System.out.print("\nEnter a book id: ");
                        bookId = menuOptionInput.nextInt();

                        if(!libraryShelf.get(bookId).getCheckedOut()) {
                            libraryPatrons.get(patronId).checkOutBook(libraryShelf.get(bookId));
                        }else {
                            System.out.println("\nSorry, this book is checked out");
                        }
                    }

                //Display all checked out books//
                }else if(userChoice == 9) {

                    if(displayCheckedOutBooks() == false) {
                        System.out.println("There are no checked out books");
                    }else {
                        displayCheckedOutBooks();
                    }

                }

            }catch(Exception ex) {
                System.out.println("An error occurred...\n");
                menuOptionInput.next();
            }
        }
        
        System.out.println("Exiting...");
    }
}
