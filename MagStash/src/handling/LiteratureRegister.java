//TODO: Move string handling to Librarian. Return collections instead.
package handling;


import entries.Literature;
import java.util.Set;
import entries.Entries;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * A class that holds all literature in a HashSet. Work in progress.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class LiteratureRegister {

    private HashSet<Entries> litRegister;

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

    public boolean addLiterature(Entries l) {
        boolean wasAdded = false;
        try {
            wasAdded = litRegister.add(l);
        } catch (java.time.DateTimeException dte) {
            //TODO: Handle the exception
        }
        return wasAdded;
    }

    /**
     * Removes a piece of literature from the set
     *
     * @param l the same issue, or an issue equal to the one you want removed
     * @return TRUE if the literature was found & removed, FALSE otherwise
     */

    public  boolean removeLiterature( Entries l) {
        boolean wasRemoved = false;
        try {
            wasRemoved = litRegister.remove(l);
        } catch (java.time.DateTimeException dte) {
            //TODO: Handle the exception
        } catch (NullPointerException npe) {
            //TODO: Handle the exception
        }
        return wasRemoved;
    }


    /**
     * Returns all Entries in LiteratureRegister as an ArrayList.
     *
     * @return
     */
    public ArrayList<Entries> getAllLiterature() {
        ArrayList<Entries> allLiterature = new ArrayList<>();
        for (Entries l : litRegister) {
            allLiterature.add(l);
        }
        return allLiterature;
    }

    /**
     * Return all literature with titles containing the given string.
     *
     * @param title the title to search for
     * @return ArrayList of all literature containing title
     */
    public  ArrayList<Entries> getByTitle( String title) {
        ArrayList<Entries> matches = new ArrayList<>();
        for (Entries l : litRegister) {

            if (l.getTitle().contains(title)) {
                matches.add(l);
            }
        }
        return matches;
    }

    /**
     * Return all literatures with a matching publisher.
     * Searches through all the magazines stored in the register.
     *
     * @param publisher Publisher to search for.
     * @return Formatted string of all literatures with matching publisher
     */

    public final ArrayList getByPublisher(final String publisher) {
        ArrayList<Entries> matches = new ArrayList<>();
        for (Entries l : litRegister) {
            if (l.getPublisher().contains(publisher)) {
                matches.add(l);
            }
        }
        return matches;
    }
    
    /**
     * Returns a copy of the HashSet as Set.
     * @return a copy of the register (HashSet) as Set
     */
    public Set<Entries> getSet() {
        Set<Entries> litSet = this.litRegister;
        return litSet;
    }
}
