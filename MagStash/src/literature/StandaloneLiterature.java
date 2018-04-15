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
public abstract class StandaloneLiterature extends Literature {
    
    private int edition;

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
            String genre, final int year, final int month, final int day,
            final int edition) {
        super(title, publisher, genre);
        this.edition = edition;
        this.releaseDate = LocalDate.of(year, month, day);
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
     * Return the edition number
     * @return the edition number
     */
    public int getEdition() {
        return this.edition;
    }
    
    /**
     * Compares this object to another to see if they're the same.
     *
     * @param o Literature to be compared to
     * @return TRUE if they're equal
     */
    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (o == this) {
            isEqual = true;
        } else if (!(o instanceof StandaloneLiterature)) {
            isEqual = false;
        } else {
            StandaloneLiterature l = (StandaloneLiterature) o;

            // Comparing of fields
            if (this.getTitle().equalsIgnoreCase(l.getTitle())
                    && this.getPublisher().equalsIgnoreCase(l.getPublisher())
                    & this.getYear() == l.getYear()
                    && this.getMonth() == l.getMonth()
                    && this.getDay() == l.getDay()) {
                isEqual = true;
            }
        }
        return isEqual;
    }
    
        @Override
    public int hashCode() {
        return (this.getTitle().length()*17
        + this.getPublisher().length()*31
                + this.getGenre().length()*3
                + this.getYear()*31
                + this.getMonth()*17
                + this.getDay()*31
                + this.getEdition()*17);
    }

}
