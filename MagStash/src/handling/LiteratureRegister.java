package handling;

import literature.Literature;
import java.util.HashSet;
import handling.ProductTypeNumbers;

/**
 * A class that holds all literature in a HashSet. Work in progress.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class LiteratureRegister {

    private HashSet<Literature> litRegister;

    /**
     * Creates a new literature register.
     */
    public LiteratureRegister() {
        litRegister = new HashSet<>();
    }

    /**
     * Adds a new piece of literature to the set.
     *
     * @param l the new literature
     * @return TRUE if the literature was added, FALSE otherwise
     */
    public final boolean addLiterature(final Literature l) {
        boolean wasAdded = false;
        try {
            wasAdded = litRegister.add(l);
        } catch (java.time.DateTimeException dateTimeException) {
            //TODO: Handle the exception
        }
        return wasAdded;
    }

    /**
     * Gives a formatted string of all literature in the register.
     *
     * @return formatted string with all literature
     */
    public final String getAllLiterature() {
        String foundLiterature = "";
        for (Literature l : litRegister) {
            foundLiterature += l.getDetailsAsString();
        }
        return foundLiterature;
    }

    /**
     * Gets all literatures held that match title.
     * The literatures are output as a formatted string.
     *
     * @param title title to search for
     * @return formatted string of all literatures matching the search
     */
    public final String getByTitle(final String title) {
        String foundLiterature = "";
        for (Literature l : litRegister) {
            if (l.getTitle().contains(title)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
    }

    /**
     * Gives all literatures with a matching publisher.
     * Searches through all the magazines stored in the register.
     *
     * @param publisher Publisher to search for.
     * @return Formatted string of all literaturees with matching publisher
     */
    public final String getByPublisher(final String publisher) {
        String foundLiterature = "";
        for (Literature l : litRegister) {
            if (l.getPublisher().contains(publisher)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
    }
}