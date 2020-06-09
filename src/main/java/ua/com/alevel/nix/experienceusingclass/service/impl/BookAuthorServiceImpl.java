package ua.com.alevel.nix.experienceusingclass.service.impl;

import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.data.BookAuthor;
import ua.com.alevel.nix.experienceusingclass.repository.BookAuthorRepository;
import ua.com.alevel.nix.experienceusingclass.repository.impl.BookAuthorRepositoryImpl;
import ua.com.alevel.nix.experienceusingclass.service.BookAuthorService;

import java.util.List;

public class BookAuthorServiceImpl implements BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository = new BookAuthorRepositoryImpl();

    public List<Book> findBooksByAuthId(Long id){return bookAuthorRepository.findBooksByAuthId(id);}

    public List<Author> findAuthByBookId(Long id){return bookAuthorRepository.findAuthByBookId(id);}

    public List<Book> findBooksByAuthor(String fullName){return bookAuthorRepository.findBooksByAuthor(fullName);}

    public List<Author> findAuthorsByBook(String bookName){return bookAuthorRepository.findAuthorsByBook(bookName);}

    public void saveOrUpdate(BookAuthor bookAuthor) {
        if (bookAuthor.getId() == null) {
            long id = findAll().size();
            bookAuthor.setId(++id);
            bookAuthorRepository.save(bookAuthor);
        } else {
            bookAuthorRepository.update(bookAuthor);
        }
    }

    public BookAuthor findById(Long id) { return bookAuthorRepository.findById(id); }

    public List<BookAuthor> findAll() {
        return bookAuthorRepository.findAll();
    }

    public void remove(Long id) {
        bookAuthorRepository.remove(id);
    }
}

