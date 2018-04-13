package literature;

/**
 * A superclass for all literature. Has all the information that is common to
 * all literatures. In reality, Literature only holds date-treating methods, but
 * we believe it's worth it to avoid rewriting them whenever creating new forms
 * of media.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Literature {

    private final String title; 
    private final String publisher;

    /**
     * Initialises Literature from a LocalDate object.
     * Automatically handles incorrect dates,
     * such as 2005/16/-2 through LocalDate.
     *
     * @param title title of the piece.
     * @param publisher publisher of the piece.
     * @param releaseDate the release date of the piece.
     * Throws a DateTimeException if the date is incorrect.
     */
    public Literature(final String title, final String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    /**
     * Initialises Literature from explicitly given year, month and day.
     * Throws a java.time.DateTimeException if the month is not between 1-12 or
     * if the day is not appropriate for the month. Automatically accounts for
     * leap years.
     *
     * For example, if the date entered is 1999/02/31, DateTimeException will
     * be thrown, as February does not have 31 days.
     *
     * @param title title of the piece.
     * @param publisher publisher of the piece.
     * @param year the release year
     * @param month the release month (1-12)
     * @param day the release day (1-31)
     */
    public Literature(final String title, final String publisher,
            final int year, final int month, final int day) {
        this.title = title;
        this.publisher = publisher;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    public final String getPublisher() {
        return this.publisher;
    }

    /**
     * Abstract class to give out the details of the piece.
     *
     * @return all details of the piece as string.
     */
    abstract public String getDetailsAsString();
}
