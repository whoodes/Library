import java.util.Date;

public class LibraryBook implements Book {

    private String title;
    private String author;
    private boolean checkedOut;
    private Date dueDate;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getAuthor(){
        return author;
    }

    @Override
    public boolean getCheckedOut() {
        return checkedOut;
    }

    @Override
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    @Override
    public Date getDueDate(){
        return dueDate;
    }

    @Override
    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

}
