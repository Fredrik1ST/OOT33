package handling;

import literature.Newspaper;
import literature.Book;
import literature.Magazine;
import handling.LiteratureRegister;

/**
 * Write a description of class Librarian here.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Librarian {

    private LiteratureRegister litReg;

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
    public boolean addLiterature(String title, String publisher,
            int year, int month, int day, int releaseNr,
            int literatureTypeNr, boolean isSeries) {
        boolean wasAdded = false;

        {
            switch (productTypes[literatureTypeNr]) {

                case "magazine": //Magazine
                    if (isSeries) {
                        // wasAdded = litReg.addLiterature(new MagazineSeries(title, publisher, year, month, day));
                    } else {
                        wasAdded = litReg.addLiterature(
                                new Magazine(title, publisher, 
                                        year, month, day, releaseNr));
                    }
                    break;

                case "newspaper": //Newspaper
                    if (isSeries) {
                        // wasAdded = litReg.add(new NewspaperSeries(title, publisher, year, month, day));
                    } else {
                        wasAdded = litReg.addLiterature(
                                new Newspaper(title, publisher, 
                                        year, month, day, releaseNr));
                    }
                    break;

                case "book": //Book
                    if (isSeries) {
                        // wasAdded = litReg.addLiterature(new BookSeries(title, publisher, year, month, day));
                    } else {
                        wasAdded = litReg.addLiterature(
                                new Book(title, publisher, year, month, day));
                    }
                    break;
            }
            return wasAdded;
        }
    }
}
