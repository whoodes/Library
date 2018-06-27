import java.util.Date;

public interface Book {

    void setTitle(String title);

    String getTitle();

    void setAuthor(String author);

    String getAuthor();

    boolean isCheckedOut();

    Date returnDate();

}

