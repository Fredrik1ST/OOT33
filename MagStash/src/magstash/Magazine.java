package magstash;

/**
 * Class that stores all relevant info for a magazine.
 *
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 0.2
 */
public class Magazine extends Literature {

    private int releaseNr;
    private int releasesPerYear;
    /**
     * Constructor for objects of class Magazine.
     *
     * @param title name of the series the magazine belongs to
     * @param publisher the magazine's publisher
     * @param releaseNr the magazine's release number
     * @param releasesPerYear number of releases of the magazine per year
     * @param year the year the magazine was released
     * @param month the month the magazine was released
     * @param day the day the magazine was released
     */
    public Magazine(String title, String publisher, int releaseNr,
            int releasesPerYear, int year, int month, int day) {
        this.title = title;
        if (releaseNr < 1) {
            releaseNr = 1;
        }
        if (releasesPerYear < releaseNr) {
            releasesPerYear = releaseNr;
        }
        if (month > 12) {
            month = 12;
        } else if (month < 1) {
            month = 1;
        }
        if (day > 31) {
            day = 31;
        } else if (day < 1) {
            day = 1;
        }
        this.publisher = publisher;
        this.releaseNr = releaseNr;
        this.releasesPerYear = releasesPerYear;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the details of the magazine as a string of text.
     *
     * @return details as string
     */
    public String getDetailsAsString() {
        return "-------------------------\n " + this.title + "\n by " 
                + this.publisher + "\n Number: " + this.releaseNr 
                + " / " + this.releasesPerYear + "\n Release date: " 
                + this.year + "/" + this.month + "/" + this.day 
                + "\n-------------------------";
    }

    /**
     * @return the name of the magazine series
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Changes the name of the magazine series.
     *
     * @param newTitle new series of the magazine
     */
    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    /**
     * @return the name of the magazine's publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Sets the publisher to something else.
     *
     * @param publisher the new publisher of the magazine
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the magazine's release number
     */
    public int getNumber() {
        return this.releaseNr;
    }

    /**
     * Changes the release number of the magazine.
     *
     * @param newNumber the magazine's new release number
     */
    public void setNumber(int newNumber) {
        this.releaseNr = newNumber;
    }

    /**
     * @return the number of releases per year
     */
    public int getReleasesPerYear() {
        return this.releasesPerYear;
    }

    /**
     * Changes the number of releases per year
     *
     * @param releasesPerYear the new number of releases per year
     */
    public void setReleasesPerYear(int releasesPerYear) {
        this.releasesPerYear = releasesPerYear;
    }

    /**
     * @return the magazine's year of release
     */
    public int getYear() {
        return this.year;
    }

    /**
     * @return the magazine's month of release
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * @return the magazine's day of release
     */
    public int getDay() {
        return this.day;
    }
}
