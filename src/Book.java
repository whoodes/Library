import java.util.Calendar;
import java.util.Date;

public interface Book {

    /**
     * Get the title of the book
     * 
     * @param title
     */
    void setTitle(String title);

    /**
     * Get the title of the book
     *
     * @return String
     */
    String getTitle();

    void setAuthor(String author);

    /**
     * Get the author of the book
     *
     * @return String
     */
    String getAuthor();

    /**
     * Get true for checked out, otherwise false
     *
     * @return String
     */
    boolean getCheckedOut();

    /**
     * True for checked out, otherwise false
     *
     * @param checkedOut
     */
    void setCheckedOut(boolean checkedOut);

    /**
     * Get the book's due date
     *
     * @return Calendar
     */
    Date getDueDate();

    /**
     * Set the book's due date
     *
     * @param dueDate
     */
    void setDueDate(Calendar dueDate);

}

