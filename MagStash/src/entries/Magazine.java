package entries;

import java.time.LocalDate;

/**
 * Class that stores all relevant info for a magazine.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Magazine extends Literature {

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
    public Magazine(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, genre, year, month, day, releaseNr);
    }

}
