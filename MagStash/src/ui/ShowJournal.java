package ui;

import literature.Journal;
/**
 * Display class for Journal objects.
 * Requires Journal class to function.
 *
 * @author Magnus
 */
public class ShowJournal {

    /**
     * Takes in a Journal and gives out a formatted string with its details.
     * @param journal the journal to get information from
     * @return formatted string with information about journal
     */
    public final String getDetailsAsString(final Journal journal) {
        return "\n-----------------------\n" + journal.getTitle()
                + "\n#" + journal.getReleaseNr()
                + "\nJournal published by " + journal.getPublisher() + "\n"
                + "Genre: " + journal.getGenre() + "\n"
                + journal.getYear() + "/" + journal.getMonth()
                + "/" + journal.getDay();
    }
}
