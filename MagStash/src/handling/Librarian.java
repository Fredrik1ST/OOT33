package handling;

import literature.*;
import handling.LiteratureRegister;
import handling.ProductTypeNumbers;
import java.util.ArrayList;

/**
 * Handles communication between the UI and Literature Register.
 * Note: typeList, of class ProductTypeNumbers, 
 * handles which int corresponds to which product type in the switch case.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Librarian {

    private LiteratureRegister litReg;
    private ProductTypeNumbers typeList;

    /**
     * Constructor for objects of class Librarian
     */
    public Librarian() {
        litReg = new LiteratureRegister();
        typeList = new ProductTypeNumbers();
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
            switch (typeList.getProductTypes()[literatureTypeNr]) {

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
     * Returns a formatted string of literature found in the provided list.
     *
     * @param allLiterature the details of the literature in the list
     * @return formatted string with all the literature
     */
    public final String getDetails(ArrayList<Literature> issues) {
        String foundLiterature = "";
        for (Literature l : issues) {
            foundLiterature += l.getDetailsAsString();
        }
        return foundLiterature;
    }
    
    /**
     * List all literature held that match the given title.
     * Searches through a provided ArrayList. The output is a formatted string.
     *
     * @param issues list of literature to search through
     * @param title title to search for
     * @return formatted string of all literatures matching the search
     */
    public final String getDetailsByTitle(ArrayList<Literature> issues,
             String title) {
        String foundLiterature = "";
        for (Literature l : issues) {
            if (l.getTitle().contains(title)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
    }
    
        /**
     * Returns details of all literature with a matching publisher.
     * Searches through a provided Arraylist.
     *
     * @param issues list of literature to search through
     * @param publisher publisher to search for
     * @return formatted string of all literaturees with matching publisher
     */
    public final String getDetailsByPublisher(ArrayList<Literature> issues,
            String publisher) {
        String foundLiterature = "";
        for (Literature l : issues) {
            if (l.getPublisher().contains(publisher)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
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
