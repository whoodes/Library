import java.util.ArrayList;
import java.util.Calendar;

public class Patron {

    private String firstName;
    private String lastName;
    private ArrayList<LibraryBook> rentals = new ArrayList<>();
    private Calendar dueDate = Calendar.getInstance();

    /**
     * Default constructor
     */
    public Patron(){
        this("John", "Doe");
    }

    /**
     * Construct a patron
     *
     * @param firstName String
     * @param lastName String
     */
    public Patron(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;

    }

    /**
     * Set the first name
     *
     * @param firstName String
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Get the last name
     *
     * @return String
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Set the last name
     *
     * @param lastName String
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Get the last name
     *
     * @return String
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Check out a LibraryBook. This will:
     * -Add the book to the Patron's ArrayList
     * -LibraryBook.setCheckedOut = true
     * -Set the due date as seven days from current date
     *
     * @param book LibraryBook
     */
    public void checkOutBook(LibraryBook book){

        rentals.add(book);
        book.setCheckedOut(true);
        dueDate.add(Calendar.DATE, 7);
        book.setDueDate(dueDate);

    }

    /**
     * Displays all LibraryBooks in the Patron's ArrayList
     *
     * @return String
     */
    public String displayCurrentBooks(){

        for(LibraryBook book : rentals){
            return book.getTitle() + "\n";
        }

        //Need a default
        return "";

    }

    /**
     * Custom toString method for a Patron
     *
     * @return String
     */
    @Override
    public String toString() {

        if (rentals.isEmpty()) {
            return getLastName() + ", " + getFirstName() + " has no books checked out.";
        }else{
            return getLastName() + ", " + getFirstName() + " has " + rentals.size() + " books checked out:\n"
                    + displayCurrentBooks();
        }

    }


}
