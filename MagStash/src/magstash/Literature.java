package magstash;

import java.time.LocalDate;

/**
 * A superclass for all literature. Has all the information that is common to 
 * all literatures. In reality, Literature only holds date-treating methods, but
 * we believe it's worth it to avoid rewriting them whenever creating new forms
 * of media.
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 2018/03/19
 */
public abstract class Literature implements Comparable<Literature> {
    private LocalDate releaseDate;
    
    // public abstract int compareTo(Literature l);
    
    /**
     * Initialises Literature from a LocalDate object. 
     * Automatically handles incorrect dates, 
     * such as 2005/16/-2 through LocalDate.
     * 
     * Throws a DateTimeException if the date is incorrect.
     * @param releaseDate the release date of the piece.
     */
    public Literature(LocalDate releaseDate){
        this.releaseDate = releaseDate;
    }
    
    /**
     * Initialises Literature from explicitly given year, month and day.
     * Throws a java.time.DateTimeException if the month is not between 1-12 or
     * if the day is not appropriate for the month. Automatically accounts for
     * leap years.
     * 
     * For example, if the date entered is 1999/02/31, DateTimeException will
     * be thrown, as February does not have 31 days.
     * @param year the release year
     * @param month the release month (1-12)
     * @param day the release day (1-31)
     */
    public Literature(int year, int month, int day){
        this.setDate(year, month, day);
    }

    /**
     * Returns the year of release.
     * @return the year of release
     */
    public int getYear() {
        return releaseDate.getYear();
    }

    /**
     * Returns the month of release
     * @return the month of release
     */
    public int getMonth() {
        return releaseDate.getMonthValue();
    }

    /**
     * Returns the day of release
     * @return the day of release
     */
    public int getDay() {
        return releaseDate.getDayOfMonth();
    }
    
    /**
     * Sets the date to a new date.
     * @param year
     * @param month
     * @param day 
     */
    public void setDate(int year, int month, int day){
        try{
            releaseDate = LocalDate.of(year, month, day);
        } catch (java.time.DateTimeException e){
            //TODO: add exception clause here
        }
    }
    
    public void setDate(LocalDate newDate){
        try{
            releaseDate = newDate;
        } catch(java.time.DateTimeException e){
            //TODO: Add exception catch here
        }
    }
    
    abstract String getDetailsAsString();
}
