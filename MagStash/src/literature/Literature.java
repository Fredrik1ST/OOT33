package literature;

import java.time.LocalDate;

/**
 * Superclass of all literature that is part of a series.
 * It simply extends the Entries superclass and pins on a release number
 for storing and sorting in series.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Literature
        extends Entries
        implements Comparable<Literature> {

    private LocalDate releaseDate;
    private int releaseNr;

    /**
     * Sorts serial literature by release number in collections.
     *
     * @param sl the literature to which this one is to be compared to
     * @return an integer to determine sorting order in collections
     */
    @Override
    public int compareTo(Literature sl) {
        return (getReleaseNr() - sl.getReleaseNr());
    }

    /**
     * Constructor for use in the Literature subclasses.
     *
     * @param title the literature's title
     * @param publisher the literature's publisher
     * @param genre
     * @param year year of release
     * @param month month of release
     * @param day day of release
     * @param releaseNr the literature's release number (in a series)
     */
    public Literature(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, genre);
        this.releaseDate = LocalDate.of(year, month, day);
        this.releaseNr = releaseNr;
    }

    /**
     * Returns the release number this literature
     *
     * @return the literature's release number (in a series)
     */
    public int getReleaseNr() {
        return this.releaseNr;
    }

    /**
     * Set the literature's release number.
     *
     * @param releaseNr the literature's release number in series, 0 for not in series
     */
    protected void setReleaseNr(int releaseNr) {
        this.releaseNr = releaseNr;
    }

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

    /**
     * Compares this object to another to see if they're the same.
     *
     * @param o Entries to be compared to
     * @return TRUE if they're equal
     */
    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (o == this) {
            isEqual = true;
        } else if (!(o instanceof Literature)) {
            isEqual = false;
        } else {
            Literature l = (Literature) o;

            // Comparing of fields
            if (this.getTitle().equalsIgnoreCase(l.getTitle())
                    && this.getPublisher().equalsIgnoreCase(l.getPublisher())
                    & this.getYear() == l.getYear()
                    && this.getMonth() == l.getMonth()
                    && this.getDay() == l.getDay()
                    && this.getReleaseNr() == l.getReleaseNr()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return (this.getTitle().length() * 17
                + this.getPublisher().length() * 31
                + this.getGenre().length() * 3
                + this.getYear() * 31
                + this.getMonth() * 17
                + this.getDay() * 31);
    }
}
