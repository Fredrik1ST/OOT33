package testing;

import entries.BookSeries;
import entries.Series;
import entries.Literature;
import entries.Book;
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
        Literature book = new Book("book", "publisher", "genre",
                1111, 11, 11, 1, "author", 0);
        boolean success = books.add(book);
        assertEquals(true, success);
    }
    
    @Test
    public void removeTest() {
        Series books = new BookSeries("series", "publisher", "genre", 0);
        Literature book = new Book("book", "publisher", "genre",
                1111, 11, 11, 1, "author", 0);
        books.add(book);
        boolean success = books.remove(book);
        assertEquals(true, success);
    }
}
