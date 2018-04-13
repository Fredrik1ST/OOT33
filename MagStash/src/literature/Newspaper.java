/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literature;

/**
 *
 * @author Fredrik
 */
public class Newspaper extends SerialLiterature {

    public Newspaper(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, genre, year, month, day, releaseNr);
    }

    /**
     * Returns a formatted string of the details of this newspaper.
     * Date format is in YYYY/MM/DD.
     *
     * @return the details as a formatted string.
     */
    @Override
    public final String getDetailsAsString() {
        return "\n-----------------------\n" + this.getTitle()
                + "\n#" + this.getReleaseNr() + "\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay();
    }
}