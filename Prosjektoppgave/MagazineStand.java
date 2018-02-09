import java.util.ArrayList;
import java.util.Iterator;
/**
 * The class where all the magazines are stored and managed.
 *
 * @author Hans Christian Haugan Finnson,
 *         Fredrik Siem Taklo,
 *         Magnus Renaa Kjørseng
 * @version 1.0
 */
public class MagazineStand
{
    private ArrayList<Magazine> magazineArchive;

    /**
     * Constructor for objects of class MagazineStand
     */
    public MagazineStand()
    {
        magazineArchive = new ArrayList<Magazine>();
    }

    /**
     * Adds a magazine with the specified information to the magazine stand.
     * @param series which series the magazine belongs to
     * @param number release number of the magazine
     * @param year the year the magazine was released
     * @param month the month the magazine was released
     * @param day the day the magazine was released
     */
    public void addMagazine(String series, int number, int year, int month, int day)
    {
        boolean duplicate = false;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((false == duplicate) && (it.hasNext()))
        {
            Magazine m = it.next();
            if ((m.getSeries().equals(series)) && (m.getNumber() == number))
            {
                duplicate = true;
            }
        }
        if (!duplicate)
        {
            magazineArchive.add(new Magazine(series, number, year, month, day));
        }
        else
        {
            System.out.println("Magazine already exists in the stand.");
        }
    }
    
    /**
     * Removes a magazine from the magazine stand.
     * @param magazineSeries name of the magazine series to find
     * @param magazineNumber number of the magazine in the series to remove
     */
    public void removeMagazine(String magazineSeries, int magazineNumber)
    {
        boolean removed = false;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while (!removed && it.hasNext())
        {
            Magazine m = it.next();
            if ((m.getSeries().equals(magazineSeries)) && (m.getNumber() == magazineNumber))
            {
                it.remove();
                removed = true;
            }
        }
        if (!removed)
        {
            System.out.println("No magazine by the given series and number found.");
        }
    }
    
    /**
     * Changes the series and number of the given magazine.
     * @param oldSeries the original series of the magazine
     * @param oldNumber the original number of the magazine
     * @param newSeries the new series for the magazine
     * @param newNumber the new number for the magazine
     */
    public void changeMagazineDetails(String oldSeries, int oldNumber, String newSeries, int newNumber) 
    {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext()))
        {
            Magazine m = it.next();
            if (m.getSeries().equals(oldSeries) && (m.getNumber() == oldNumber))
            {
                foundMagazine = m;
                m.setSeries(newSeries);
                m.setNumber(newNumber);
            }
        }
        if (null == foundMagazine)
        {
            System.out.println("No magazine by the given series and number found.");
        }
    } 
    
    /**
     * Returns the current number of magazines in the stand.
     * @return number of magazines
     */
    public int getNumberOfMagazines()
    {
        return magazineArchive.size();
    } 
    
    /**
     * Searches the magazine stand for a particular magazine.
     * @param magazineSeries name of the magazine series to search the stand for
     * @param magazineNumber number of the magazine in the series to get
     * @return search result
     */
    public Magazine getMagazine(String magazineSeries, int magazineNumber)
    {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext()))
        {
            Magazine m = it.next();
            if (m.getSeries().equals(magazineSeries) && (m.getNumber() == magazineNumber))
            {
                System.out.println(m.getDetailsAsString());
                foundMagazine = m;
            }
        }
        if (null == foundMagazine)
        {
            System.out.println("No magazine by the given series and number found.");
        }
        return foundMagazine;
    }
    
    /**
     * Search the stand for a magazine series by its name, and display all magazines found in the terminal.
     * @param magazineSeries name of the magazine series to search for 
     */
    public void listMagazineSeries(String magazineSeries)
    {
        boolean foundSeries = false;
        for (Magazine m : this.magazineArchive)
        {
            if (m.getSeries().equals(magazineSeries))
            {
                System.out.println(m.getDetailsAsString());
                foundSeries = true;
            }
        }
        if (!foundSeries)
        {
            System.out.println("No magazines by the given series found.");
        }
    }
    
    /**
     * List all magazines currently found in the stand in the terminal.
     */
    public void listAllMagazines()
    {
        for (Magazine m : this.magazineArchive)
        {
            System.out.println(m.getDetailsAsString());
        }
    }
}
