import java.util.Calendar;

public interface Book {

    void setTitle(String title);

    String getTitle();

    void setAuthor(String author);

    String getAuthor();

    boolean getCheckedOut();

    void setCheckedOut(boolean checkedOut);

    Calendar getDueDate();

    void setDueDate(Calendar dueDate);

}

