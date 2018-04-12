package magstash;

import java.time.LocalDate;

/**
 * Class that stores all relevant info for a magazine.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 2018/03/19
 */
public class Magazine extends SerialLiterature {

    /**
     * Creates a new magazine from explicitly given date.
     *
     * @param year the release year of the magazine
     * @param month the release month of the magazine (1-12)
     * @param day the release day of the magazine (1-31)
     * @param title the title of the magazine series
     * @param publisher the publisher of the magazine
     * @param releaseNr the release number of the magazine
     */
    public Magazine(String title, String publisher,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, releaseNr, year, month, day);
    }

    public Magazine(String title, String publisher,
            int year, int month, int day) {
        super(title, publisher, year, month, day, 1);
    }

    /**
     * Creates a new magazine from LocalDate.
     *
     * @param releaseDate
     * @param releaseNr
     */
    public Magazine(String title, String publisher,
            LocalDate releaseDate, int releaseNr) {
        super(title, publisher, releaseDate, releaseNr);
    }

    /**
     * Returns a formatted string of the details of this magazine.
     * Date format is in YYYY/MM/DD.
     *
     * @return the details as a formatted string.
     */
    @Override
    public final String getDetailsAsString() {
        return "-----------------------\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay()
                + "\n Nummer: " + getReleaseNr();
    }

}
