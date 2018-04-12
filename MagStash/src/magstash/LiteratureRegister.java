package magstash;

import java.util.HashSet;

/**
 * A class that holds all literature in a HashSet. Work in progress.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
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
     * @param l the new literature
     * @return TRUE if the literature was added, FALSE otherwise
     */
    public boolean addLiterature(Literature l) {
        boolean isAdded = false;
        try {
            isAdded = litRegister.add(l);
        } catch (java.time.DateTimeException dateTimeException) {
            //TODO: Handle the exception
        }
        return isAdded;
    }
    /**
     * Gets all literatures held that match title.
     * The literatures are output as a formatted string.
     * @param title title to search for
     * @return formatted string of all literatures matching the search
     */
    public final String getByTitle(final String title) {
        String foundLiterature = "";
        for (Literature l : litRegister) {
            if (l.getTitle().equals(title)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
    }

    public String getByPublisher(String publisher) {
        String foundLiterature = "";
        for (Literature l : litRegister) {
            if (l.getPublisher().equals(publisher)) {
                foundLiterature += l.getDetailsAsString();
            }
        }
        return foundLiterature;
    }
}
