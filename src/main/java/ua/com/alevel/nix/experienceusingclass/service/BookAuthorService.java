package ua.com.alevel.nix.experienceusingclass.service;

import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.data.BookAuthor;

import java.util.List;

public interface BookAuthorService extends AbstractService<BookAuthor> {
    List<Book> findBooksByAuthId(Long id);
    List<Author> findAuthByBookId(Long id);
    List<Book> findBooksByAuthor(String fullName);
    List<Author> findAuthorsByBook(String bookName);
}
