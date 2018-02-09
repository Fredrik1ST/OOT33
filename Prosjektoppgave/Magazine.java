
/**
 * Write a description of class Magazine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Magazine
{
    private String name;
    private int releaseNr;
    private int year;
    private int month;
    private int day;
    
    /**
     * Constructor for objects of class Magazine
     */
    public Magazine(String name, int releaseNr, int year, int month, int day)
    {
        this.name = name;
        this.releaseNr = releaseNr;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the details of the magazine as a string of text.
     * @return the details of the magazine as a string of text.
     */
    public String getDetailsAsString()
    {
        return "-------------------------\n'" + this.name + "'\nNumber: " + this.releaseNr + "\nRelease date: " + this.year + "/" + this.month + "/" + this.day;
    }
    
    /**
     * Returns the name of the magazine.
     * @return the name of the magazine.
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Returns the number of the magazine.
     * @return the number of the magazine.
     */
    public int getNumber()
    {
        return this.releaseNr;
    }
    
    /**
     * Returns the year of the magazine's release.
     * @return the year of the magazine's release.
     */
    public int getYear()
    {
        return this.year;
    }
    
    /**
     * Returns the month of the magazine's release.
     * @return the month of the magazine's release.
     */
    public int getMonth()
    {
        return this.month;
    }
    
    /**
     * Returns the day of the magazine's release.
     * @return the day of the magazine's release.
     */
    public int getDay()
    {
        return this.day;
    }
}
