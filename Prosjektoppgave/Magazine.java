
/**
 * Class that stores all relevant info for a magazine. 
 *
 * @author Hans Christian Haugan Finnson,
 *         Fredrik Siem Taklo,
 *         Magnus Renaa Kjørseng
 * @version 1.0
 */
public class Magazine
{   
    private String series;
    private String publisher;
    private int releaseNr;
    private int releasesPerYear;
    private int year;
    private int month;
    private int day;
    
    /**
     * Constructor for objects of class Magazine.
     * @param series which series the magazine belongs to
     * @param releaseNr release number of the magazine
     * @param year the year the magazine was released
     * @param month the month the magazine was released
     * @param day the day the magazine was released
     */
    public Magazine(String series,String publisher, int releaseNr, 
    int releasesPerYear, int year, int month, int day)
    {
        this.series = series;
        if (releaseNr < 0){releaseNr = 1;}
        if (month > 12){month = 12;}
        else if (month < 1) { month = 1; }
        if (day > 31) { day = 31; }
        else if (day < 1) { day = 1; }
        this.publisher = publisher;
        this.releaseNr = releaseNr;
        this.releasesPerYear = releasesPerYear;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the details of the magazine as a string of text.
     * @return details as string.
     */
    public String getDetailsAsString() 
    {
        return "-------------------------\n'" + this.series + "'\nNumber: " 
        + this.releaseNr + "\nRelease date: " + this.year + "/" + this.month 
        + "/" + this.day;
    }
    
    /**
     * Returns the name of the magazine series.
     * @return series
     */
    public String getSeries()
    {
        return this.series;
    }
    
    /**
     * Changes the series of the magazine.
     * @param newSeries new series of the magazine
     */
    public void setSeries(String newSeries)
    {
        this.series = newSeries;
    }
    
    /**
     * Gets the publisher of the magazine
     * @return publisher of the magazine
     */
    public String getPublisher()
    {
        return this.publisher;
    }
    
    /**
     * Sets the publisher to something else
     * @param publisher the new publisher of the magazine
     */
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    /**
     * Returns the number of the magazine.
     * @return magazine number
     */
    public int getNumber()
    {
        return this.releaseNr;
    }
    
    /**
     * Changes the number of the magazine.
     * @param newNumber new number of the magazine
     */
    public void setNumber(int newNumber)
    {
        this.releaseNr = newNumber;
    }
    
    /**
     * Returns the number of releases per year
     * @return The number of releases per year
     */
    public int getReleasesPerYear()
    {
        return this.releasesPerYear;
    }
    
    /**
     * Changes the number of releases per year
     * @param releasesPerYear the new number of releases per year
     */
    public void setReleasesPerYear(int releasesPerYear)
    {
        this.releasesPerYear = releasesPerYear;
    }
    
    /**
     * Returns the year of the magazine's release.
     * @return year
     */
    public int getYear()
    {
        return this.year;
    }
    
    /**
     * Returns the month of the magazine's release.
     * @return month
     */
    public int getMonth()
    {
        return this.month;
    }
    
    /**
     * Returns the day of the magazine's release.
     * @return day
     */
    public int getDay()
    {
        return this.day;
    }
}
