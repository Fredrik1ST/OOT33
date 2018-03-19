package magstash;

import java.util.Map;
import java.util.HashMap;

/**
 * A container class to hold all literature. 
 * All literature types are kept in their respective series collections. Single
 * books, magazines or other types are still counted as series of size 1. Each 
 * Series has a boolean isSeries, that tells whether it should be counted 
 * as such, meaning that single books and similar can be counted as not series.
 * 
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 2018/03/19
 */
public class LiteratureCache {
    private Map<String, MagazineSeries> magazineArchive;
    
    public LiteratureCache(){
        magazineArchive = new HashMap<>();
        
    }
    
    /**
     * Adds a MagazineSeries with the given values.
     * @param seriesName name of the new series
     * @param releasesPerYear number of releases per year
     * @param publisher publisher of the series
     * @param genre genre of the series
     * @return TRUE if the MagazineSeries was added and there were no collisions
     * @return FALSE otherwise.
     */
    public boolean addMagazineSeries(String seriesName, int releasesPerYear,
            String publisher, String genre){
        boolean added = false;
        if (!magazineArchive.containsKey(seriesName)){
            magazineArchive.put(seriesName, 
                    new MagazineSeries(seriesName, releasesPerYear,
                            publisher, genre));
            added = true;
        }
        
        return added;
    }
    
    /**
     * Gets the magazine series to be worked with. 
     * @param seriesName the name of the series to get to
     * @return The magazine series requested.
     */
    public MagazineSeries getMagazineSeries(String seriesName){
        return magazineArchive.get(seriesName);
    }
    
    /**
     * Gets the name of all MagazineSeries as a formatted string.
     * The format is:
     * 
     * MagazineSeries1
     * MagazineSeries2
     * MagazineSeries3
     * 
     * @return All the MagazineSeries names held as formatted string
     */
    public String listAllMagazineSeries() {
        String allMagazineSeries = "";
        for(Map.Entry<String, MagazineSeries> entry : 
                magazineArchive.entrySet()){
            allMagazineSeries += entry.getValue().getSeriesName() + "\n"; 
        }
        
        return allMagazineSeries;
    }
    
    /**
     * Finds whether the given series exists yet.
     * @param seriesName the name of the series
     * @return TRUE if the series exists, FALSE otherwise.
     */
    public boolean hasMagazineSeries(String seriesName){
        return magazineArchive.containsKey(seriesName);
    }
}
