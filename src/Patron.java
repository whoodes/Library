import java.util.ArrayList;
import java.util.Iterator;

public class Patron {

    private String firstName;
    private String lastName;
    private ArrayList<LibraryBook> rentals = new ArrayList<>();

    public Patron(){
        this("John", "Doe");
    }

    public Patron(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void checkOutBook(LibraryBook book){
        rentals.add(book);
    }

    public String displayCurrentBooks(){
        for(LibraryBook book : rentals){
            return book.getTitle() + "\n";
        }
        return "\n";
    }

    public String toString() {
        if (rentals.isEmpty()) {
            return getLastName() + ", " + getFirstName() + " has no books checked out.";
        }else{
            return getLastName() + ", " + getFirstName() + " has " + rentals.size() + " books checked out:\n"
                    + displayCurrentBooks();
        }
    }

}
