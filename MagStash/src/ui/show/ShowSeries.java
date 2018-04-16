package ui.show;

import literature.Series;

/**
 *
 * @author Fredrik
 */
public class ShowSeries {
    
    public ShowSeries() {
    }
    

    /**
     * Takes in a Series and displays its most basic details.
     * @param s series to display
     * @return formatted String of information about the Series
     */
    public static String getDetailsAsString(Series s) {
        String issuesPerYear = "";
        if (s.getReleasesPerYear() > 0) {
            issuesPerYear = "\nIssues per year: " + s.getReleasesPerYear();
        }
        return ("\n***********************\n" + s.getTitle() + "\n"
                + "Series published by " + s.getPublisher() + "\n"
                + "# of issues: " + s.getSize()
                + issuesPerYear);
    }
}
