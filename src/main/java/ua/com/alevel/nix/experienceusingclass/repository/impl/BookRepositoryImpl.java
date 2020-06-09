package ua.com.alevel.nix.experienceusingclass.repository.impl;

import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final List<Book> bookList = new ArrayList<>();

    public Book findByBookName(String bookName) {
        for (Book book : bookList){
            if (book.getBookName().equals(bookName))
                return book;
        }
        return null;
    }


    public void save(Book book) {
        bookList.add(book);
    }

    public Book findById(Long id) {
        for (Book book : bookList){
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return bookList;
    }

    public void update(Book book) {
        for (Book currBook : bookList){
            if (book.getId().equals(currBook.getId())){
                currBook.setBookName(book.getBookName());
            }
        }
    }

    public void remove(Long id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.remove(i);
            }
        }
    }
}
