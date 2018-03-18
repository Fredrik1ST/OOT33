package magstash;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class where all the magazines are stored and managed.
 * Constructs and manages an array list of "Magazine"-objects.
 *
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 0.2
 */
public class MagazineStand extends Series {

    private ArrayList<Magazine> magazineArchive;

    /**
     * Constructor for objects of class MagazineStand
     */
    public MagazineStand() {
        magazineArchive = new ArrayList<Magazine>();
    }

    /**
     * Adds a magazine with the specified information to the magazine stand.
     *
     * @param series which series the magazine belongs to
     * @param publisher the publisher of the magazine
     * @param number release number of the magazine
     * @param numberPerYear the number of magazines released per year
     * @param year the year the magazine was released
     * @param month the month the magazine was released
     * @param day the day the magazine was released
     * @return TRUE if magazine got added, FALSE if not (duplicate)
     */
    public boolean addMagazine(String series, String publisher, int number,
            int numberPerYear, int year, int month, int day) {
        boolean duplicate = isDuplicate(series, number);
        if (!duplicate) {
            magazineArchive.add(new Magazine(series, publisher, number,
                    numberPerYear, year, month, day));
        }
        return !duplicate;
    }

    /**
     * Removes a magazine from the magazine stand.
     *
     * @param magazineSeries name of the magazine series to find
     * @param magazineNumber number of the magazine in the series to remove
     */
    public void removeMagazine(String magazineSeries, int magazineNumber) {
        boolean removed = false;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while (!removed && it.hasNext()) {
            Magazine m = it.next();
            if ((m.getTitle().equals(magazineSeries))
                    && (m.getNumber() == magazineNumber)) {
                it.remove();
                removed = true;
            }
        }
        if (!removed) {
            System.out.println(
                    "No magazine by the given series and number found.");
        }
    }

    /**
     * Changes the series and number of the given magazine.
     *
     * @param oldSeries the original series of the magazine
     * @param oldNumber the original number of the magazine
     * @param newSeries the new series for the magazine
     * @param newNumber the new number for the magazine
     */
    public void changeMagazineDetails(String oldSeries, int oldNumber,
            String newSeries, int newNumber) {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext())) {
            Magazine m = it.next();
            if (m.getTitle().equals(oldSeries) && (m.getNumber() == oldNumber)) {
                foundMagazine = m;
                m.setTitle(newSeries);
                m.setNumber(newNumber);
            }
        }
    }

    /**
     * Returns the current number of magazines in the stand.
     *
     * @return number of magazines
     */
    public int getNumberOfMagazines() {
        return magazineArchive.size();
    }

    /**
     * Searches the magazine stand for a particular magazine.
     *
     * @param magazineSeries name of the magazine series to search the stand for
     * @param magazineNumber number of the magazine in the series to get
     * @return search result
     */
    public Magazine getMagazine(String magazineSeries, int magazineNumber) {
        Magazine foundMagazine = null;
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((null == foundMagazine) && (it.hasNext())) {
            Magazine m = it.next();
            if (m.getTitle().equals(magazineSeries)
                    && (m.getNumber() == magazineNumber)) {
                System.out.println(m.getDetailsAsString());
                foundMagazine = m;
            }
        }
        return foundMagazine;
    }

    /**
     * Search the stand for a magazine series by its name, and display all
     * magazines found in the terminal.
     *
     * @param magazineSeries name of the magazine series to search for
     */
    public void listMagazineSeries(String magazineSeries) {
        boolean foundSeries = false;
        for (Magazine m : this.magazineArchive) {
            if (m.getTitle().equals(magazineSeries)) {
                System.out.println(m.getDetailsAsString());
                foundSeries = true;
            }
        }
        if (!foundSeries) {
            System.out.println("No magazines by the given series found.");
        }
    }

    /**
     * List all magazines currently found in the stand in the terminal.
     *
     * @return a list (string) of all Magazines in the MagazineStand
     */
    public String listAllMagazines() {
        String magazineList = "";
        for (Magazine m : this.magazineArchive) {
            magazineList = magazineList + "\n" + m.getDetailsAsString();
        }
        return magazineList;
    }
    
    /**
     * Checks if a magazine of the given series name and release number already
     * exists in the magazine stand. 
     * @param series the name of the magazine series
     * @param number the release number of the magazine in the given series
     * @return TRUE if the magazine already exists in the stand, FALSE if not
     */
    public boolean isDuplicate(String series, int number){
        boolean alreadyInStand = false;
        if (number < 1) {
            number = 1;
        }
        Iterator<Magazine> it = this.magazineArchive.iterator();
        while ((false == alreadyInStand) && (it.hasNext())) {
            Magazine m = it.next();
            if ((m.getTitle().equals(series)) && (m.getNumber() == number)) {
                alreadyInStand = true;
            }
        }
        return alreadyInStand;
    }
}