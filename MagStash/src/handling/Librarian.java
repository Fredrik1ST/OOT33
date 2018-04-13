package handling;

import literature.*;
import handling.LiteratureRegister;
import handling.ProductTypeNumbers;

/**
 * Handles communication between the UI and Literature Register
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Librarian {

    private LiteratureRegister litReg;
    private ProductTypeNumbers typeList;

    /**
     * Designates a number (through array indexing) to each product type.
     * These numbers are universally used to present the product types.
     */
    public final String[] productTypes
            = {
                "type error", /*     0 */
                "book", /*           1 */
                "magazine", /*       2 */
                "journal", /*        3 */
                "newspaper", /*      4 */};

    /**
     * Constructor for objects of class Librarian
     */
    public Librarian() {
        litReg = new LiteratureRegister();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public boolean addLiterature(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr,
            int literatureTypeNr, String author) {
        boolean wasAdded = false;

        {
            switch (productTypes[literatureTypeNr]) {

                case "magazine": //Magazine
                    wasAdded = litReg.addLiterature(
                            new Magazine(title, publisher, genre,
                                    year, month, day, releaseNr));

                    break;

                case "newspaper": //Newspaper
                    wasAdded = litReg.addLiterature(
                            new Newspaper(title, publisher, genre,
                                    year, month, day, releaseNr));

                    break;

                case "book": //Book
                    wasAdded = litReg.addLiterature(
                            new Book(title, publisher, genre,
                                    year, month, day, author));
                    break;
            }
            return wasAdded;
        }
    }

    /**
     * Convert a standalone piece of literature (like a book) to serial format.
     *
     * @param l the literature to convert
     * @param releaseNr the converted literature's new release number
     * @return the new Serial Literature, or NULL upon error
     */
    public SerialLiterature
            convertToSerial(StandaloneLiterature l, int releaseNr) {

        SerialLiterature newSerial;
        String title = l.getTitle();
        String publisher = l.getPublisher();
        String genre = l.getGenre();
        int year = l.getYear();
        int month = l.getMonth();
        int day = l.getDay();
        String author;

        if (l instanceof Book) {
            author = ((Book) l).getAuthor();
            newSerial = new SerialBook(title, publisher, genre,
                    year, month, day, releaseNr, author);
        }
        else {
            newSerial = null;
        }
        return newSerial;
    }
}
