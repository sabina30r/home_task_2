package ua.com.alevel.nix.experienceusingclass.repository.impl;

import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.data.BookAuthor;
import ua.com.alevel.nix.experienceusingclass.repository.BookAuthorRepository;

import java.util.ArrayList;
import java.util.List;

public class BookAuthorRepositoryImpl implements BookAuthorRepository {

    private final List<BookAuthor> bookAuthorList = new ArrayList<>();

    public List<Book> findBooksByAuthId(Long id){
        List<Book> books = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthorList) {
            if (bookAuthor.getAuthor().getId().equals(id)) {
                books.add(bookAuthor.getBook());
            }
        }
        return books;
    }

    public List<Book> findBooksByAuthor(String fullName){
        List<Book> books = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthorList) {
            if (bookAuthor.getAuthor().getFullName().equals(fullName)) {
                books.add(bookAuthor.getBook());
            }
        }
        return books;
    }

    public List<Author> findAuthByBookId(Long id){
        List<Author> authors = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthorList) {
            if (bookAuthor.getBook().getId().equals(id)) {
                authors.add(bookAuthor.getAuthor());
            }
        }
        return authors;
    }

    public List<Author> findAuthorsByBook(String bookName){
        List<Author> authors = new ArrayList<>();
        for (BookAuthor bookAuthor : bookAuthorList) {
            if (bookAuthor.getBook().getBookName().equals(bookName)) {
                authors.add(bookAuthor.getAuthor());
            }
        }
        return authors;
    }

    public List<BookAuthor> findAll() {
        return bookAuthorList;
    }

    public BookAuthor findById(Long id) {
        for (BookAuthor bookAuthor : bookAuthorList){
            if (bookAuthor.getId().equals(id)){
                return bookAuthor;
            }
        }
        return null;
    }

    public void save(BookAuthor bookAuthor) {
        bookAuthorList.add(bookAuthor);
    }

    public void update(BookAuthor bookAuthor) {
        for (BookAuthor currBookAuthor : bookAuthorList ){
                if (bookAuthor.getId().equals(currBookAuthor.getId())) {
                    currBookAuthor.setBook(bookAuthor.getBook());
                    currBookAuthor.setAuthor(bookAuthor.getAuthor());
                }
        }
    }

    public void remove(Long id) {
        for (int i = 0; i < bookAuthorList.size(); i++) {
            if (bookAuthorList.get(i).getId().equals(id)) {
                bookAuthorList.remove(i);
            }
        }
    }


}
