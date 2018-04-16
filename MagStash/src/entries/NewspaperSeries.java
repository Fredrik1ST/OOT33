package entries;

/**
 * Series of Journals
 *
 * @author Fredrik
 */
public class NewspaperSeries extends Series {

    public NewspaperSeries(String title, String publisher, String genre,
            int releasesPerYear) {
        super(title, publisher, genre, releasesPerYear);
    }

    /**
     * Add a new issue to the series.
     *
     * @param issue issue to be added
     * @return boolean confirming that issue has been added to series
     */
    @Override
    public boolean add(Literature issue) {
        boolean wasAdded = false;

        if (issue instanceof Newspaper) {
            wasAdded = addIssue(issue);
        }

        return wasAdded;

    }
    
    /**
     * Removes an issue from the series.
     *
     * @param issue issue to be removed
     * @return TRUE if the issue was removed
     */
    @Override
    public boolean remove(Literature issue) {
        boolean wasRemoved = false;

        if (issue instanceof Newspaper) {
            wasRemoved = removeIssue(issue);
        }

        return wasRemoved;

    }
}
