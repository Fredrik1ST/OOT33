/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literature;

/**
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 *
 */
public class Journal extends SerialLiterature {

    // Constructor for Journal
    public Journal(String title, String publisher,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, year, month, day, releaseNr);
    }

    /**
     * Returns a formatted string of the details of this Journal.
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
