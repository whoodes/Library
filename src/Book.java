import java.util.Date;

public interface Book {

    void setTitle(String title);

    String getTitle();

    void setAuthor(String author);

    String getAuthor();

    boolean getCheckedOut();

    void setCheckedOut(boolean checkedOut);

    Date getDueDate();

    void setDueDate(Date dueDate);

}

