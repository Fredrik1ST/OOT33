package literature;

/**
 * Series of Journals
 *
 * @author Fredrik
 */
public class MagazineSeries extends Series {

    public MagazineSeries(String title, String publisher, String genre,
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
    public boolean add(SerialLiterature issue) {
        boolean wasAdded = false;

        if (issue instanceof Magazine) {
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
    public boolean remove(SerialLiterature issue) {
        boolean wasRemoved = false;

        if (issue instanceof Magazine) {
            wasRemoved = removeIssue(issue);
        }

        return wasRemoved;

    }
}
