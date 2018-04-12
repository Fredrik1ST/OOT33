package magstash;

import java.time.LocalDate;

/**
 * Superclass of all literature that is part of a series.
 * It simply extends the Literature superclass
 *
 * @author Fredrik
 */
public abstract class SerialLiterature
        extends Literature
        implements Comparable<SerialLiterature> {

    private int releaseNr;

    // Sorts serial literature by release number in collections.
    @Override
    public int compareTo(SerialLiterature sl) {
        return (getReleaseNr() - sl.getReleaseNr());
    }

    public SerialLiterature(String title, String publisher, int year, int month, int day, int releaseNr) {
        super(title, publisher, year, month, day);
        this.releaseNr = releaseNr;
    }

    public SerialLiterature(String title, String publisher, LocalDate releaseDate, int releaseNr) {
        super(title, publisher, releaseDate);
        this.releaseNr = releaseNr;
    }

    public int getReleaseNr() {
        return this.releaseNr;
    }

    protected void setReleaseNr(int releaseNr) {
        this.releaseNr = releaseNr;
    }

}
