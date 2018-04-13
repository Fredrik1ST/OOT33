package literature;

import java.time.LocalDate;

/**
 * Superclass of all literature that is part of a series.
 * It simply extends the Literature superclass and pins on a release number
 * for storing and sorting in series.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class SerialLiterature
        extends Literature
        implements Comparable<SerialLiterature> {

    private LocalDate releaseDate;
    private int releaseNr;

    /**
     * Sorts serial literature by release number in collections.
     *
     * @param sl the literature to which this one is to be compared to
     * @return an integer to determine sorting order in collections
     */
    @Override
    public int compareTo(SerialLiterature sl) {
        return (getReleaseNr() - sl.getReleaseNr());
    }

    /**
     * Constructor for use in the SerialLiterature subclasses.
     *
     * @param title the literature's title
     * @param publisher the literature's publisher
     * @param year year of release
     * @param month month of release
     * @param day day of release
     * @param releaseNr the literature's release number (in a series)
     */
    public SerialLiterature(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, genre);
        this.releaseDate = LocalDate.of(year, month, day);
        this.releaseNr = releaseNr;
    }

    /**
     * Constructor for use in the SerialLiterature subclasses with LocalDate.
     *
     * @param title the literature's title
     * @param publisher the literature's publisher
     * @param releaseDate date of release as a LocalDate object
     * @param releaseNr the literature's release number (in a series)
     */
    public SerialLiterature(String title, String publisher, String genre,
            LocalDate releaseDate, int releaseNr) {
        super(title, publisher, genre);
        this.releaseDate = (releaseDate);
        this.releaseNr = releaseNr;
    }

    /**
     * Returns the release number of a particular instance of serial literature.
     *
     * @return the literature's release number (in a series)
     */
    public int getReleaseNr() {
        return this.releaseNr;
    }

    /**
     * Set or change the literature's release number.
     *
     * @param releaseNr the literature's release number (in a series)
     */
    protected void setReleaseNr(int releaseNr) {
        this.releaseNr = releaseNr;
    }
    
     /**
     * Returns the title
     */
    /**
     * Returns the year of release.
     *
     * @return the year of release
     */
    public final int getYear() {
        return releaseDate.getYear();
    }

    /**
     * Returns the month of release.
     *
     * @return the month of release
     */
    public final int getMonth() {
        return releaseDate.getMonthValue();
    }

    /**
     * Returns the day of release.
     *
     * @return the day of release
     */
    public final int getDay() {
        return releaseDate.getDayOfMonth();
    }

}
