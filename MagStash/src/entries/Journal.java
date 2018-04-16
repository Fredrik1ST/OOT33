/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entries;

/**
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 *
 */
public class Journal extends Literature {

    // Constructor for Journal
    public Journal(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr) {
        super(title, publisher, genre, year, month, day, releaseNr);
    }


}
