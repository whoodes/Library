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
    private static String enterChoice = "Please enter a corresponding number from the option list: ";

    /*
    In case the number of options available changes
    these variables will appear in the user input loop
    guards in the main method.
     */
    private static int lowOption = 1;
    private static int highOption = 10;

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
    public ArrayList<LibraryBook> searchByBook(String key) {

        ArrayList<LibraryBook> results = new ArrayList<>();

        for (LibraryBook b : libraryShelf) {

            if (b.getTitle().contains(key) || b.getAuthor().contains(key)) {
                results.add(b);
            }else{
                continue;
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
            }else{
                continue;
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
            }else {
                continue;
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
                while (userInputLoopGuard == false) {

                    System.out.print(enterChoice);
                    userChoice = menuOptionInput.nextInt();

                    if (userChoice >= lowOption && userChoice <= highOption) {
                        userInputLoopGuard = true;
                        continue;
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
                    continue;
                }


            }catch(Exception ex){
                System.out.println("An error occurred...\n");
                menuOptionInput.next();
            }



        }

    }


}
