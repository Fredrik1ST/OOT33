package ui.show;

import entries.Newspaper;
/**
 *
 * @author Muzzhum
 */
public class ShowNewspaper {

    /**
     * Takes in a Newspaper and gives out a formatted string.
     * @param newspaper the newspaper to get information from
     * @return formatted string with information about newspaper
     */
    public static String getDetailsAsString(Newspaper newspaper) {
        return "\n-----------------------\n" + newspaper.getTitle()
                + "\n#" + newspaper.getReleaseNr()
                + "\nNewspaper published by " + newspaper.getPublisher() + "\n"
                + "Genre: " + newspaper.getGenre() + "\n"
                + newspaper.getYear() + "/" + newspaper.getMonth()
                + "/" + newspaper.getDay();
    }
}
