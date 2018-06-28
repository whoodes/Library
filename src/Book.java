import java.util.Date;

public interface Book {

    void setTitle(String title);

    String getTitle();

    void setAuthor(String author);

    String getAuthor();

    boolean getCheckedOut();

    void setCheckedOut(boolean checkedOut);

    Date getReturnDate();

    void setDueDate(Date dueDate);

}

