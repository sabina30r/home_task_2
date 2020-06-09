package ua.com.alevel.nix.experienceusingclass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.alevel.nix.experienceusingclass.builder.DataBuilder;
import ua.com.alevel.nix.experienceusingclass.config.ApplicationEnvironment;
import ua.com.alevel.nix.experienceusingclass.data.Author;
import ua.com.alevel.nix.experienceusingclass.data.Book;
import ua.com.alevel.nix.experienceusingclass.data.BookAuthor;
import ua.com.alevel.nix.experienceusingclass.service.AuthorService;
import ua.com.alevel.nix.experienceusingclass.service.BookAuthorService;
import ua.com.alevel.nix.experienceusingclass.service.BookService;

public class ServiceTest {

    DataBuilder dataBuilder = new DataBuilder();
    BookService bookService = dataBuilder.getBookService();
    AuthorService authorService = dataBuilder.getAuthorService();
    BookAuthorService bookAuthorService = dataBuilder.getBookAuthorService();

    @BeforeAll
    public static void setEnv() {
        ApplicationEnvironment.setPropertyLang("en");
    }

    @Test
    public void findAllTest() {
        dataBuilder.buildDataList();
        assertTrue(bookService.findAll().size() == 10);
        assertEquals(6, authorService.findAll().size());
    }

    @Test
    public void findByIdTest() {
        dataBuilder.buildDataList();
        assertEquals("Clean Code: A Handbook of Agile Software Craftsmanship",bookService.findById(1L).getBookName());

        assertEquals(3,bookAuthorService.findBooksByAuthId(1L).size());

        assertEquals("Bjarne Stroustrup",authorService.findById(2L).getFullName());

        assertEquals(1,bookAuthorService.findAuthByBookId(1L).size());
    }

    @Test
    public void findByNamesTest() {
        dataBuilder.buildDataList();
        assertEquals(bookService.findByBookName("The C programming language").getBookName(), "The C programming language");

        assertEquals(authorService.findByFullName("Dennis Ritchie").getFullName(), "Dennis Ritchie");

        assertEquals(bookAuthorService.findBooksByAuthor("Bjarne Stroustrup").size(), 3);

        assertEquals(2, bookAuthorService.findAuthorsByBook("The C programming language").size());

    }

    @Test
    public void removeTest() {
        dataBuilder.buildDataList();
        bookService.remove(1L);
        assertTrue(bookService.findAll().size() == 9);

        authorService.remove(1L);
        assertTrue(authorService.findAll().size() == 5);

        bookAuthorService.remove(1L);
        assertTrue(bookAuthorService.findAll().size() == 9);
    }

    @Test
    public void saveOrUpdateTest(){
        dataBuilder.buildDataList();
        Book book = new Book();
        Author auth = new Author();
        BookAuthor bookAuth = new BookAuthor();

        book.setBookName("Steve McConnell ");
        bookService.saveOrUpdate(book);
        auth.setFullName("Code Complete");
        authorService.saveOrUpdate(auth);
        bookAuth.setBook(book);
        bookAuth.setAuthor(auth);
        bookAuthorService.saveOrUpdate(bookAuth);
        assertEquals(bookService.findAll().size(),11);
        assertTrue(authorService.findAll().size() == 7);
        assertTrue(bookAuthorService.findAll().size() == 11);
    }

}
