package magstash;

import java.time.LocalDate;

/**
 * Class that stores all relevant info for a magazine.
 *
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 2018/03/19
 */
public class Magazine extends Literature {

    private int releaseNr;
    
    @Override
    public int compareTo(Literature l) {
        Magazine m = (Magazine) l;
        return (this.releaseNr - m.getReleaseNr());
    }
    
    /**
     * Creates a new magazine from explicitly given date.
     * @param year the release year of the magazine
     * @param month the release month of the magazine (1-12)
     * @param day the release day of the magazine (1-31)
     * @param releaseNr the release number of the magazine
     */
    public Magazine(int year, int month, int day, int releaseNr){
        super(year, month, day);
        this.releaseNr = releaseNr;
    }

    /**
     * Creates a new magazine from LocalDate.
     * @param releaseDate 
     * @param releaseNr 
     */
    public Magazine (LocalDate releaseDate, int releaseNr){
        super(releaseDate);
        this.releaseNr = releaseNr;
    }
    
    /**
     * Returns a formatted string of the details of this magazine. 
     * Date format is in YYYY/MM/DD.
     * @return the details as a formatted string.
     */
    @Override
    public String getDetailsAsString(){
        return "-----------------------\n" 
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay()
                + "\n Nummer: " + this.releaseNr;
    }

    /**
     * Returns this release's release number.
     * @return the releaseNr
     */
    public int getReleaseNr() {
        return releaseNr;
    }

    /**
     * Changes this release's release number.
     * @param releaseNr the releaseNr to set
     */
    public void setReleaseNr(int releaseNr) {
        this.releaseNr = releaseNr;
    }
    
    public boolean isDuplicate(int year, int month, int day, int releaseNr) {
        if (super.getYear() == year &&
                super.getMonth() == month &&
                super.getDay() == day &&
                getReleaseNr() == releaseNr) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
