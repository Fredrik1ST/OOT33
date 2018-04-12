package magstash;

import java.util.HashSet;

/**
 * A class that holds all literature in a HashSet. Work in progress.
 * 
 * @author Fredrik
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
     */
    public void addLiterature(Literature l) {
        try {
            litRegister.add(l);
        } catch (java.time.DateTimeException dateTimeException) {
            //TODO: Handle the exception
        }
    }
    
    public Literature getByTitle(String title) {
        return null;
    }
    
    public Literature getByPublisher(String publisher) {
        return null;
    }
}