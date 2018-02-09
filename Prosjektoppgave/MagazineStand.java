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
     */
    public void removeMagazine(String magazineName,int magazineNumber)
    {
       boolean removed = false;
       Iterator<Magazine> it = this.magazineArchive.iterator();
       while(!removed && it.hasNext())
       {
           Magazine m = it.next();
           if((m.getName().equals(magazineName)) && (m.getNumber() == magazineNumber))
           {
               it.remove();
               removed = true;
           }
       }
       
    }
    
    /**
     * Changes the name and number of the given magazine.
     */
    public void changeMagazineDetails(String oldName,int oldNumber,String newName,int newNumber) 
    {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext()))
        {
            Magazine m = it.next();
            if (m.getName().equals(oldName) && (m.getNumber() == oldNumber))
            {
                foundMagazine = m;
                m.setName(newName);
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
     */
    public Magazine getMagazine(String magazineName, int magazineNumber)
    {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext()))
        {
            Magazine m = it.next();
            if (m.getName().equals(magazineName) && (m.getNumber() == magazineNumber))
            {
                System.out.println(m.getDetailsAsString());
                foundMagazine = m;
            }
        }
        return foundMagazine;
    }
    
    /**
     * Search the stand for a magazine series by its name, and display all magazines found in the terminal.
     */
    public void listMagazineSeries(String name)
    {
        for (Magazine m:this.magazineArchive)
        {
            if(m.getName().equals(name))
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
