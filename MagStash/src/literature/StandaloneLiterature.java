/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literature;

import java.time.LocalDate;

/**
 *
 * @author Fredrik
 */
public abstract class StandaloneLiterature extends Literature{
    
    private LocalDate releaseDate;

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
    public StandaloneLiterature(final String title, final String publisher,
            String genre, final int year, final int month, final int day) {
        super(title, publisher, genre);
        this.releaseDate = LocalDate.of(year, month, day);
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
