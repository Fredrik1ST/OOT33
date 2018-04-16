package testing;

import literature.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class SeriesTest {

    public SeriesTest() {
    }

    @Test
    public void addTest() {
        Series books = new BookSeries("series", "publisher", "genre", 0);
        SerialLiterature book = new SerialBook("book", "publisher", "genre",
                1111, 11, 11, 1, "author");
        boolean success = books.add(book);
        System.out.println(books.getDetailsAsString());
        assertEquals(true, success);
    }
    
    @Test
    public void removeTest() {
        Series books = new BookSeries("series", "publisher", "genre", 0);
        SerialLiterature book = new SerialBook("book", "publisher", "genre",
                1111, 11, 11, 1, "author");
        books.add(book);
        boolean success = books.remove(book);
        System.out.println(books.getDetailsAsString());
        assertEquals(true, success);
    }
}
