import java.util.Calendar;

public class LibraryBook implements Book {

    private String title;
    private String author;
    private boolean checkedOut;
    private Calendar dueDate = Calendar.getInstance();

    /**
     * Set the title of the book
     *
     * @param title String
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the title of the book
     *
     * @return String
     */
    @Override
    public String getTitle(){
        return title;
    }

    /**
     * Set the Author of the book
     *
     * @param author String
     */
    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get the Author of the book
     *
     * @return string
     */
    @Override
    public String getAuthor(){
        return author;
    }

    /**
     * Get whether the book is checked out
     *
     * @return boolean
     */
    @Override
    public boolean getCheckedOut() {
        return checkedOut;
    }

    /**
     * Set whether the book is checked out
     *
     * @param checkedOut boolean
     */
    @Override
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    /**
     * Get the due date of the book
     *
     * @return Calendar
     */
    @Override
    public Calendar getDueDate(){
        return dueDate;
    }

    /**
     * Set the due date of the book
     *
     * @param dueDate Calendar
     */
    @Override
    public void setDueDate(Calendar dueDate){
        this.dueDate = dueDate;
    }


}
