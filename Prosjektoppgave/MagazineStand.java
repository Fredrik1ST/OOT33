import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class MagazineStand here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * 
     */
    public void addMagazine(Magazine magazine)
    {
       magazineArchive.add(magazine);
    }
    
    /**
     * 
     */
    public void removeMagazine(Magazine magazine)
    {
       /*
        
       Iterator<Magazine> it = m.iterator();
       while(it.hasNext())
       {
           Magazine m = it.next();
           String magazineName = m.getName();
           if(magazineName.equals(magazine))
           {
               
           }
       }
       */
    }
    
    /**
     * 
     */
    public String getMagazineByName(String magazineName)
    {
        Magazine foundMagazine = null;
        int index = 0;
        
        while ((null == foundMagazine) && (index < this.magazineArchive.size()))
        {
            Magazine m = this.magazineArchive.get(index);
            if (m.getName().equals(magazineName))
            {
                foundMagazine = m;
            }
        }
        
        return magazineName;
    }
    
    /**
     * 
     */
    public void listMagazines()
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
    
    /**
     * 
     */
    public void viewMagazineSeries(String name)
    {
       for (Magazine m:this.magazineArchive)
        {
            if(m.getName().equals(name))
            {
                ;
            }
        }
    }
}
