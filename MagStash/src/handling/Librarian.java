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
     * Adds a piece of literature to the register.
     *
     * @param title title of literature
     * @param publisher publisher of literature
     * @param genre genre of literature
     * @param year year of release
     * @param month month of release
     * @param day day of release
     * @param releaseNr release number in a series
     * @param literatureTypeNr literature type from ProductTypeNumbers
     * @param author author of literature
     * @param edition edition number of literature
     * @return TRUE if literature was added
     */
    public boolean addLiterature(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr,
            int literatureTypeNr, String author, int edition) {
        boolean wasAdded = false;

        {
            switch (typeList.getProductTypes()[literatureTypeNr]) {

                case "book": //Book
                    wasAdded = litReg.addLiterature(
                            new Book(title, publisher, genre,
                                    year, month, day, author, edition));
                    break;

                case "magazine": //Magazine
                    wasAdded = litReg.addLiterature(
                            new Magazine(title, publisher, genre,
                                    year, month, day, releaseNr));

                    break;

                case "journal": //Journal
                    wasAdded = litReg.addLiterature(
                            new Journal(title, publisher, genre,
                                    year, month, day, releaseNr));
                    break;

                case "newspaper": //Newspaper
                    wasAdded = litReg.addLiterature(
                            new Newspaper(title, publisher, genre,
                                    year, month, day, releaseNr));
                    break;

                default:
                    break;
            }
            return wasAdded;
        }
    }

    /**
     * Remove a piece of literature to the register.
     *
     * @param title title of literature
     * @param publisher publisher of literature
     * @param genre genre of literature
     * @param year year of release
     * @param month month of release
     * @param day day of release
     * @param releaseNr release number in a series
     * @param literatureTypeNr literature type from ProductTypeNumbers
     * @param author author of literature
     * @param edition edition number of literature
     * @return TRUE if literature was added
     */
    public boolean removeLiterature(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr,
            int literatureTypeNr, String author, int edition) {
        boolean wasRemoved = false;

        {
            switch (typeList.getProductTypes()[literatureTypeNr]) {

                case "book": //Book
                    wasRemoved = litReg.removeLiterature(
                            new Book(title, publisher, genre,
                                    year, month, day, author, edition));
                    break;

                case "magazine": //Magazine
                    wasRemoved = litReg.removeLiterature(
                            new Magazine(title, publisher, genre,
                                    year, month, day, releaseNr));

                    break;

                case "journal": //Journal
                    wasRemoved = litReg.removeLiterature(
                            new Journal(title, publisher, genre,
                                    year, month, day, releaseNr));
                    break;

                case "newspaper": //Newspaper
                    wasRemoved = litReg.removeLiterature(
                            new Newspaper(title, publisher, genre,
                                    year, month, day, releaseNr));
                    break;

                default:
                    break;
            }
            return wasRemoved;
        }
    }

    /**
     * Creates a new series (ArrayList) and adds it to the register.
     *
     * @param title title of series
     * @param publisher publisher of series
     * @param genre genre of series
     * @param literatureTypeNr literature type from ProductTypeNumbers
     * @return TRUE if the series was added
     */
    public boolean addSeries(String title, String publisher, String genre,
            int releasesPerYear, int literatureTypeNr) {
        {
            boolean wasAdded = false;

            {
                switch (typeList.getProductTypes()[literatureTypeNr]) {

                    case "book": //Book
                        wasAdded = litReg.addLiterature(
                                new BookSeries(title, publisher,
                                        genre, releasesPerYear));
                        break;

                    case "magazine": //Magazine
                        wasAdded = litReg.addLiterature(
                                new MagazineSeries(title, publisher,
                                        genre, releasesPerYear));

                        break;

                    case "journal": //Journal
                        wasAdded = litReg.addLiterature(
                                new JournalSeries(title, publisher,
                                        genre, releasesPerYear));
                        break;

                    case "newspaper": //Newspaper
                        wasAdded = litReg.addLiterature(
                                new NewspaperSeries(title, publisher, genre,
                                        releasesPerYear));
                        break;

                    default:
                        break;
                }
                return wasAdded;
            }
        }
    }

    /**
     * Removes a series from the register.
     *
     * @param title title of series
     * @param publisher publisher of series
     * @param genre genre of series
     * @param literatureTypeNr literature type from ProductTypeNumbers
     * @return TRUE if the series was added
     */
    public boolean removeSeries(String title, String publisher, String genre,
            int releasesPerYear, int literatureTypeNr) {
        {
            boolean wasRemoved = false;

            {
                switch (typeList.getProductTypes()[literatureTypeNr]) {

                    case "book": //Book
                        wasRemoved = litReg.removeLiterature(
                                new BookSeries(title, publisher,
                                        genre, releasesPerYear));
                        break;

                    case "magazine": //Magazine
                        wasRemoved = litReg.removeLiterature(
                                new MagazineSeries(title, publisher,
                                        genre, releasesPerYear));

                        break;

                    case "journal": //Journal
                        wasRemoved = litReg.removeLiterature(
                                new JournalSeries(title, publisher,
                                        genre, releasesPerYear));
                        break;

                    case "newspaper": //Newspaper
                        wasRemoved = litReg.removeLiterature(
                                new NewspaperSeries(title, publisher, genre,
                                        releasesPerYear));
                        break;

                    default:
                        break;
                }
                return wasRemoved;
            }
        }
    }

    /**
     * Fetches all content in the literature register as an ArrayList.
     *
     * @return ArrayList of all Literature in the register
     */
    public final ArrayList<Literature> getRegister() {
        return litReg.getAllLiterature();
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
        } else {
            newSerial = null;
        }
        return newSerial;
    }

    /**
     * Fills up the register with various literature. For testing.
     */
    public void fillRegister() {
        litReg.addLiterature(new Book(
                "A book", "some publisher", "a genre", 1995, 11, 18, "author", 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 2));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 3));
        Series series = new MagazineSeries(
                "A magazine", "some publisher", "a genre", 3);
        series.add(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 1));
        series.add(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 2));
        series.add(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 3));
        litReg.addLiterature(series);

    }
}
