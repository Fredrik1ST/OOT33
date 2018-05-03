package entries;

import java.util.Map;
import java.util.TreeMap;

/**
 * A superclass for series. Its purpose is to keep general information that all
 * series have, whether book series, magazines, or other, in order to keep code
 * cleaner.
 * 
 * TreeMap sorted by SerialLiterature's release numbers in ascending order.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Series extends Entry {

    private int releasesPerYear;
    private TreeMap<Integer, Literature> issues;

    /**
     * Initialises the series with all fields filled.
     *
     * @param title the name of the series
     * @param publisher the publisher of the series
     * @param genre the genre of the series
     * @param releasesPerYear number of releases per year
     */
    public Series(String title, String publisher, String genre,
            int releasesPerYear) {
        super(title, publisher, genre);
        this.releasesPerYear = releasesPerYear;
        issues = new TreeMap<>();
    }

    /**
     * For subclasses:
     * Used to add issue (using addIssue) after confirming correct type/class.
     *
     * @return a boolean confirming that the issue was added
     */
    abstract public boolean add(Literature sl);

    /**
     * Adds an issue of serial literature to the series.
     *
     * @param sl Literature to be added
     * @return a boolean confirming that the issue was added
     */
    protected boolean addIssue(Literature sl) {
        try {
            boolean wasAdded = false;

            issues.put(sl.getReleaseNr(), sl);
            wasAdded = true;
             
            return wasAdded;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * For subclasses:
     * Used to remove an issue (using removeIssue) after confirming correct type
     * @param sl
     * @return TRUE if the issue was removed
     */
    abstract public boolean remove(Literature sl);
    
    /**
     * Removes an issue of serial literature from the series.
     *
     * @param sl Literature to be removed
     * @return a boolean confirming that the issue was removed
     */
    protected boolean removeIssue(Literature sl) {
        try {
            if (issues.containsValue(sl)) {
            issues.remove(sl.getReleaseNr());
            }
            return true;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Returns the objects in the series in a TreeMap
     * @return the contents of the series in a TreeMap
     */
    public TreeMap<Integer, Literature> getIssues() {
        TreeMap<Integer, Literature> foundIssues = issues;
        return foundIssues;
    }
    
    /**
     * Returns releases per year.
     *
     * @return releases per year
     */
    public int getReleasesPerYear() {
        return this.releasesPerYear;
    }

    /**
     * Returns the number of issues in the series.
     *
     * @return the number of issues in the series
     */
    public int getSize() {
        return this.issues.size();
    }

    /**
     * Compares this object to another to see if they're the same.
     *
     * @param o Entry to be compared to
     * @return TRUE if they're equal
     */
    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (o == this) {
            isEqual = true;
        } else if (!(o instanceof Series)) {
            isEqual = false;
        } else {
            Series s = (Series) o;

            // Comparing of fields
            if (this.getTitle().equalsIgnoreCase(s.getTitle())
                    && this.getPublisher().equalsIgnoreCase(s.getPublisher())
                    && this.getSize() == s.getSize()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return (this.getTitle().length() * 17
                + this.getPublisher().length() * 31
                + this.getGenre().length() * 17
                + this.getReleasesPerYear() * 31);
    }
    
    public TreeMap<Integer, Literature> getMap() {
        return issues;
    }
}
