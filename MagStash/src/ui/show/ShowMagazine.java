package ui.show;

import entries.Magazine;

/**
 * Display class for Magazines. Requires Magazine class to function.
 * Exists to decrease coupling and increase cohesion.
 * @author Magnus
 */
public class ShowMagazine {

    /**
     * Takes in a Magazine and gives out a formatted string with its details.
     * @param magazine the magazine to get information from
     * @return formatted string with information about magazine
     */
    public static String getDetailsAsString(Magazine magazine) {
        return "\n-----------------------\n" + magazine.getTitle()
                + "\n#" + magazine.getReleaseNr()
                + "\nMagazine published by " + magazine.getPublisher() + "\n"
                + "Genre: " + magazine.getGenre() + "\n"
                + magazine.getYear() + "/" + magazine.getMonth()
                + "/" + magazine.getDay();
    }
}
