package ua.com.alevel.nix.experienceusingclass.data;

public class Book extends AbstractData<Book> {

    private String bookName;
    private String uq;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

}
