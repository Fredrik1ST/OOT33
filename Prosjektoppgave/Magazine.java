
/**
 * Class that stores all relevant info for a magazine. 
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
        this.month = month%12;
        this.day = day%31;
    }

    /**
     * Returns the details of the magazine as a string of text.
     * @return details as string.
     */
    public String getDetailsAsString()
    {
        return "-------------------------\n'" + this.name + "'\nNumber: " + this.releaseNr + "\nRelease date: " + this.year + "/" + this.month + "/" + this.day;
    }
    
    /**
     * Returns the name of the magazine.
     * @return name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Changes the name of the magazine
     * @param 
     */
    public void setName(String newName)
    {
        this.name = newName;
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
     * @param
     */
    public void setNumber(int newNumber)
    {
        this.releaseNr = newNumber;
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
