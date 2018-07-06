import java.util.ArrayList;
import java.util.Scanner;

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
    private static String enterChoice = "\nPlease enter a corresponding number from the option list: ";

    /*
    In case the number of options available changes
    these variables will appear in the user input loop
    guards in the main method.
     */
    private static int lowOption = 1;
    private static int highOption = 10;

    /**
     * Display the current Patrons.
     *
     * @return String
     */
    public static void displayPatrons() {

        for (int i = 0; i < libraryPatrons.size(); i++) {
            System.out.println("ID: " + i + ". " + libraryPatrons.get(i).toString() + "\n");

        }

    }

    /**
     * Display the current LibraryBooks.
     *
     * @return String
     */
    public static void displayLibraryBooks(){

        for (int i = 0; i < libraryShelf.size(); i++) {
            System.out.println("ID: " + i + ". " + libraryShelf.get(i).toString() + "\n");

        }

    }

    /**
     * Check each LibraryBook in the system against
     * a String key.  If there is a match return true,
     * otherwise return false.
     *
     * @param key String
     * @return boolean
     */
    public ArrayList<LibraryBook> searchByBook(String key) {

        ArrayList<LibraryBook> results = new ArrayList<>();

        for (LibraryBook b : libraryShelf) {
            if (b.getTitle().contains(key) || b.getAuthor().contains(key)) {
                results.add(b);
            }
        }

        return results;

    }

    /**
     * Check each Patron in the system against
     * a String key. If there is a match return true,
     * otherwise return false.
     *
     * @param key String
     * @return boolean
     */
    public ArrayList<Patron> searchByPatron(String key){

        ArrayList<Patron> results = new ArrayList<>();

        for(Patron p : libraryPatrons){
            if(p.getFirstName().contains(key) || p.getLastName().contains(key)){
                results.add(p);
            }
        }

        return results;

    }

    /**
     * Display all of the checked out books in the system
     *
     * @return String
     */
    public String diplayAllCheckedOutBooks(){

        for(LibraryBook b : libraryShelf){
            if(b.getCheckedOut()){
                return b.toString();
            }
        }

        return "";

    }

    public static void main(String[] args){

        System.out.println(welcomeMessage + options);

        int userChoice = 0; //Defaulted
        boolean userInputLoopGuard;

        //Independent inputs//
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
                }else if(userChoice == 2){

                    System.out.println();
                    displayPatrons();
                    System.out.print("\nSelect the patron id: ");
                    userChoice = menuOptionInput.nextInt();
                    libraryPatrons.remove(userChoice);

                //Add a LibraryBook//
                }else if(userChoice == 3){

                    String title;
                    String author;
                    System.out.print("Enter the title: ");
                    title = createModifyInput.nextLine();
                    System.out.print("Enter the author: ");
                    author = createModifyInput.nextLine();
                    LibraryBook b = new LibraryBook(title, author);
                    libraryShelf.add(b);

                }


            }catch(Exception ex){
                System.out.println("An error occurred...\n");
                menuOptionInput.next();
            }



        }

    }


}
