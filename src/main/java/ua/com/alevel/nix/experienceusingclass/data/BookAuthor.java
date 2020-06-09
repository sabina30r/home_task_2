package ua.com.alevel.nix.experienceusingclass.data;

import ua.com.alevel.nix.experienceusingclass.repository.AuthorRepository;

public class BookAuthor extends AbstractData<BookAuthor> {

    private Book book;
    private Author author;

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book = book; }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
