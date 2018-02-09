import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class MagazineStand here.
 * The MagazineClass class is where all the magazines are stored. ____
 *
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
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
     * Adds a magazine to the magazine stand.
     */
    public void addMagazine(Magazine magazine)
    {
       magazineArchive.add(magazine);
    }
    
    /**
     * Removes a magazine from the magazine stand.
     * @param magazineSeries name of the magazine series to find
     * @param magazineNumber number of the magazine in the series to remove
     */
    public void removeMagazine(String magazineSeries,int magazineNumber)
    {
       boolean removed = false;
       Iterator<Magazine> it = this.magazineArchive.iterator();
       while(!removed && it.hasNext())
       {
           Magazine m = it.next();
           if((m.getSeries().equals(magazineSeries)) && (m.getNumber() == magazineNumber))
           {
               it.remove();
               removed = true;
           }
       }
       
    }
    
    /**
     * Changes the series and number of the given magazine.
     * @param oldSeries the original series of the magazine
     * @param oldNumber the original number of the magazine
     * @param newSeries the new series for the magazine
     * @param newNumber the new number for the magazine
     */
    public void changeMagazineDetails(String oldSeries,int oldNumber,String newSeries,int newNumber) 
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
    } 
    
    /**
     * Returns the number of magazines currently in the stand
     * @return number of magazines
     */
    public int getNumberOfMagazines()
    {
        return magazineArchive.size();
    } 
    
    /**
     * Searches the magazine stand for a particular magazine
     * @param magazineSeries name of the magazine series to search the stand for
     * @parem magazineNumber number of the magazine in the series to get
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
        return foundMagazine;
    }
    
    /**
     * Search the stand for a magazine series by its name, and display all magazines found in the terminal
     * @param magazineSeries name of the magazine series to search for 
     */
    public void listMagazineSeries(String magazineSeries)
    {
        for (Magazine m:this.magazineArchive)
        {
            if(m.getSeries().equals(magazineSeries))
            {
                System.out.println(m.getDetailsAsString());
            }
        }
    }
    
    /**
     * List all magazines currently found in the magazine stand in the terminal.
     */
    public void listAllMagazines()
    {
       for (Magazine m:this.magazineArchive)
       {
           System.out.println(m.getDetailsAsString());
       }
    }
    
    /**
     * 
     */
    public void listMagazinesByDate()
    {
       ;
    }
   
}
