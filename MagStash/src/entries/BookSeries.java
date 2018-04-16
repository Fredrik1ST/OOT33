package entries;

/**
 * Series of SerialBooks
 *
 * @author Fredrik
 */
public class BookSeries extends Series {

    public BookSeries(String title, String publisher, String genre,
            int releasesPerYear) {
        super(title, publisher, genre, releasesPerYear);
    }

    /**
     * Add a new issue to the series.
     *
     * @param issue issue to be added
     * @return TRUE if the issue was added
     */
    @Override
    public boolean add(Literature issue) {
        boolean wasAdded = false;

        if (issue instanceof Book) {
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

        if (issue instanceof Book) {
            wasRemoved = removeIssue(issue);
        }

        return wasRemoved;

    }
}
