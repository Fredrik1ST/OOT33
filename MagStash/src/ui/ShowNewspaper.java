package ui;

import literature.Newspaper;
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
    public final String getDetailsAsString(final Newspaper newspaper) {
        return "\n-----------------------\n" + newspaper.getTitle()
                + "\n#" + newspaper.getReleaseNr()
                + "\nNewspaper published by " + newspaper.getPublisher() + "\n"
                + "Genre: " + newspaper.getGenre() + "\n"
                + newspaper.getYear() + "/" + newspaper.getMonth()
                + "/" + newspaper.getDay();
    }
}
