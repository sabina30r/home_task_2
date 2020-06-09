package ua.com.alevel.nix.experienceusingclass.builder;

import ua.com.alevel.nix.experienceusingclass.config.ApplicationEnvironment;
import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.data.BookAuthor;
import ua.com.alevel.nix.experienceusingclass.service.AuthorService;
import ua.com.alevel.nix.experienceusingclass.service.BookAuthorService;
import ua.com.alevel.nix.experienceusingclass.service.BookService;
import ua.com.alevel.nix.experienceusingclass.service.impl.AuthorServiceImpl;
import ua.com.alevel.nix.experienceusingclass.service.impl.BookAuthorServiceImpl;
import ua.com.alevel.nix.experienceusingclass.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataBuilder implements AbstractBuilder {

    private final AuthorService authorService = new AuthorServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private final BookAuthorService bookAuthorService = new BookAuthorServiceImpl();

    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {

            Author author = new Author();
            String authorNameProperties = String.join(" ", entry.getKey().split("_"));
            author.setFullName(authorNameProperties);
            authorService.saveOrUpdate(author);

            if (entry.getValue().contains(";")) {
                List<String> bookNamePropertiesList = Arrays.asList(entry.getValue().split(";"));
                bookNamePropertiesList.forEach(bookName -> {
                    Book book = new Book();
                    book.setBookName(bookName);
                    bookService.saveOrUpdate(book);
                    BookAuthor bookAuthor = new BookAuthor();
                    bookAuthor.setBook(book);
                    bookAuthor.setAuthor(author);
                    bookAuthorService.saveOrUpdate(bookAuthor);
                    bookService.saveOrUpdate(book);
                });
            } else {
                Book book = new Book();
                String bookName = entry.getValue();
                book.setBookName(bookName);
                bookService.saveOrUpdate(book);
                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setAuthor(author);
                bookAuthor.setBook(book);
                bookAuthorService.saveOrUpdate(bookAuthor);
                bookService.saveOrUpdate(book);
            }

        }

        /*bookService.findAll().forEach(book -> {
            System.out.println("book = " + book.getBookName());
        });*/

}

    public AuthorService getAuthorService() {
        return authorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public BookAuthorService getBookAuthorService() {return bookAuthorService;}
}
