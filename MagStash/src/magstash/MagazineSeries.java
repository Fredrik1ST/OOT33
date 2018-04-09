package magstash;

import java.util.Iterator;
import java.time.LocalDate;
import java.util.TreeSet;

/**
 * A container class for magazines. Its purpose is to avoid needing to enter 
 * recurring information, such as publisher, releases per year and series name.
 * 
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 2018/03/19
 */
public class MagazineSeries extends Series {
    private TreeSet<Magazine> magazines;
    private int releasesPerYear;
    
    
    /**
     * Creates a new, empty MagazineSeries with all fields filled. 
     * @param seriesName Name of the series
     * @param releasesPerYear Number of releases per year
     * @param publisher The publisher of the series
     * @param genre The genre of the series
     */
    public MagazineSeries(String seriesName, int releasesPerYear, 
            String publisher, String genre){
        super(seriesName, publisher, genre);
        magazines = new TreeSet<>();
        this.releasesPerYear = releasesPerYear;
    }
    
    /**
     * Adds a magazine to the series by an already existing magazine.
     * If the magazine is already in the series,it is not added
     * and an error is raised (NYI).
     * @param magazine the magazine to be added
     * @return TRUE if the magazine was added, FALSE otherwise.
     */
    public boolean addMagazine(Magazine magazine){   
        return magazines.add(magazine);
    }
    
    /**
     * Adds a magazine from explicit date.
     * @param year release year
     * @param month release month (1-12)
     * @param day release date (1-31)
     * @param releaseNr release number.
     * @return TRUE if magazine added successfully, FALSE otherwise.
     */
    public boolean addMagazine(int year, int month, int day, int releaseNr){
        return magazines.add(new Magazine(year, month, day, releaseNr));
    }
    
    /**
     * Removes the given magazine from the series, if it is there.
     * If the magazine is not in the series, it returns false.
     * @param magazine the magazine to be removed
     * @return TRUE if the magazine was removed, FALSE otherwise.
     */
    public boolean removeMagazine(Magazine magazine) {
        return magazines.remove(magazine);
    }
    
    /**
     * Gets the total number of magazines in the series.
     * @return the number of magazines in the series
     */
    public int getNumberOfMagazines(){
        return magazines.size();
    }
    
    /**
     * Gets a specific magazine by Magazine.
     * @param magazine the Magazine to be found
     * @return the Magazine in the series.
     * @return NULL if the magazine is not in the series
     */
    public Magazine getMagazine(Magazine magazine){
        Magazine foundMagazine = null;
        if (magazines.contains(magazine)){
            boolean found = false;
            Iterator<Magazine> it = this.magazines.iterator();
            while(!found && it.hasNext()){
                Magazine nextMagazine = it.next();
                if (nextMagazine.equals(magazine)){
                    found = true;
                    foundMagazine = nextMagazine;
                }
            }
        } else{
            //TODO: The magazine is not in the collection, handle it.
        }
        
        return foundMagazine;
    }
    
    /**
     * Returns a list (String) of all magazines in the series.
     * @return ArrayList with all magazines with matching release numbers
     */
    @Override
    public String getProductsAsString(){
        String foundMagazines = "";
        Iterator<Magazine> it = this.magazines.iterator();
        
        while (it.hasNext()){
            Magazine nextMag = it.next();
                foundMagazines += nextMag.getDetailsAsString() + "\n";
        }
        
        return foundMagazines;
    }
    
        /**
     * Returns a String of magazines with a matching releaseNr.
     * @param releaseNr number to search for
     * @return String with all magazines with matching release numbers
     */
    public String listByReleaseNr(int releaseNr){
        String foundMagazines = "";
        Iterator<Magazine> it = this.magazines.iterator();
        
        while (it.hasNext()){
            Magazine nextMag = it.next();
            if (nextMag.getReleaseNr() == releaseNr){
                foundMagazines += nextMag.getDetailsAsString() + "\n";
            }
        }
        
        return foundMagazines;
}
    
    /**
     * Changes the date of the magazine.
     * @param magazine the magazine to change
     * @param newDate the new date of the magazine
     */
    public void setMagazineDate(Magazine magazine, LocalDate newDate){
        if (magazines.contains(magazine)){
            getMagazine(magazine).setDate(newDate);
        } else {
            //TODO: Add response here, magazine does not exist
        }
    }
    
    /**
     * Changes the release number of the given magazine. 
     * @param magazine the magazine to be changed
     * @param releaseNr the new release number
     */
    public void setMagazineReleaseNumber(Magazine magazine, int releaseNr){
        if (magazines.contains(magazine)){
            getMagazine(magazine).setReleaseNr(releaseNr);
        } else {
            //TODO: Add response here, magazine does not exist
        }
    }
    
    /**
     * Lists all magazines in the series as a formatted string.
     * @return A formatted string of all magazines in this series.
     */
    public String listAllMagazines(){
        String magazineList = this.getSeriesName() 
                + " utgitt av " + this.getPublisher() 
                + "\n Genre: " + this.getGenre() + "\n";
        for(Magazine m : this.magazines){
            magazineList += m.getDetailsAsString();
            magazineList += "/" + this.releasesPerYear 
                    + "\n -----------------------";
        }
        
        return magazineList;
    }
    
    /**
     * Returns the number of releases per year.
     * @return the releasesPerYear
     */
    public int getReleasesPerYear() {
        return releasesPerYear;
    }

    /**
     * Sets the number of releases per year.
     * @param releasesPerYear the releasesPerYear to set
     */
    public void setReleasesPerYear(int releasesPerYear) {
        this.releasesPerYear = releasesPerYear;
    }
}
