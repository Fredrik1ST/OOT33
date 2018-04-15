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
            int releasesPerYear, int literatureTypeNr) 
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

    /**
     * Finds an existing literature and moves it to an existing series.
     * What actually happens is as follows
     * <ul>
     *      <li> The correct series is found
     *      <li> The correct piece of literature is found
     *      <li> The literature is removed from its original place
     *      <li> The literature and found series are checked for compatibility
     *      <li> The literature is added to the series
     * </ul>
     * 
     * @param seriesName name of the series
     * @param lit literature to add to the series
     * @param literatureTypeNr literature type from ProductTypeNumbers
     * @return TRUE if the operation was a success, FALSE otherwise
     */
    public boolean addToSeries(String seriesName, String title, 
            String publisher, int literatureTypeNr) {
        boolean wasAdded = false;
        ArrayList<Literature> serialMatches = litReg.getByTitle(seriesName);
        for (Literature l : serialMatches)
        {
            if (!(l instanceof Series)) // We only want series here
            {
                serialMatches.remove(l);
            }
        }
        
        // This should give only one match, but we check to be sure
        ArrayList<Literature> titleMatches = litReg.getByTitle(title);
        Literature titleMatch = null;
        if (titleMatches.size() == 1) {
            titleMatch = titleMatches.get(0);
        }
        
        // This should also return only one match, but check still
        ArrayList<Literature> publisherMatches = 
                litReg.getByPublisher(publisher);
        Literature publisherMatch = null;
        if (publisherMatches.size() == 1) {
            publisherMatch = publisherMatches.get(0);
        }
        
        // If both the title and the publishers match, we assume this is the 
        // right piece of literature and we take it.
        Literature lit = null;
        if (titleMatch != null && publisherMatch != null) {
            if (titleMatch == publisherMatch) {
                lit = titleMatch;
                litReg.removeLiterature(titleMatch);
            }    
        } else {
            // TODO: add some error message, the search wasn't precise enough
        }
        
        // We only want to add stuff if we're sure we have the right series
        // Therefore, if there are more than one match, we don't have enough
        // specificity in our search
        if (serialMatches.size() == 1 && lit != null) {
            switch (typeList.getProductTypes()[literatureTypeNr]) {

                case "book": { //Book 
                    if (serialMatches.get(0) instanceof BookSeries && 
                            lit instanceof SerialBook) {
                        BookSeries bs = (BookSeries)serialMatches.get(0);
                        wasAdded = bs.add((SerialBook)lit);
                    }
                    break;
                }
                case "magazine": //Magazine
                    if (serialMatches.get(0) instanceof MagazineSeries &&
                            lit instanceof Magazine) {
                        MagazineSeries ms = (MagazineSeries)serialMatches.get(0);
                        wasAdded = ms.add((Magazine) lit);
                    }
                    break;

                case "journal": //Journal
                    if (serialMatches.get(0) instanceof JournalSeries &&
                            lit instanceof Journal) {
                        JournalSeries js = (JournalSeries)serialMatches.get(0);
                        wasAdded = js.add((Journal) lit);
                    }
                    break;

                case "newspaper": //Newspaper
                    if (serialMatches.get(0) instanceof NewspaperSeries &&
                            lit instanceof Newspaper) {
                        NewspaperSeries nps = (NewspaperSeries)serialMatches.get(0);
                        wasAdded = nps.add((Newspaper) lit);
                    }
                    break;

                default:
                    break;
            }
        } else {
            //TODO: make a message that the search term isn't specific enough
        }
        
        return wasAdded; 
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
}
