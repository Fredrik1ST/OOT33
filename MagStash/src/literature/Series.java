package literature;

import java.util.Map;
import java.util.TreeMap;

/**
 * A superclass for series. Its purpose is to keep general information that all
 * series have, whether book series, magazines, or other, in order to keep code
 * cleaner.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Series extends Literature {

    TreeMap<Integer, SerialLiterature> issues;

    /**
     * Initializes the series with all fields filled.
     *
     * @param title the name of the series
     * @param publisher the publisher of the series
     * @param genre the genre of the series
     */
    public Series(String title, String publisher, String genre) {
        super(title, publisher, genre);
        issues = new TreeMap<>();
    }

    /**
     * For subclasses:
     * Used to add issue (using addIssue) after confirming correct type/class.
     * @return a boolean confirming that the issue was added
     */
    abstract public boolean add(SerialLiterature sl);
    
    /**
     * Add an issue of serial literature to the series.
     *
     * @param sl SerialLiterature to be added
     * @return a boolean confirming that the issue was added
     */
    protected boolean addIssue(SerialLiterature sl) {
        try {
            boolean wasAdded = false;
            if (issues.put(sl.getReleaseNr(), sl) != null) {
                wasAdded = true;
            }
            return wasAdded;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Remove an issue of serial literature from the series.
     *
     * @param sl SerialLiterature to be removed
     * @return a boolean confirming that the issue was removed
     */
    protected boolean removeIssue(SerialLiterature sl) {
        try {
            issues.remove(sl.getReleaseNr(), sl);
            return true;
        } catch (NullPointerException npe) {
            return false;
        }
    }

    /**
     * Returns a list (String) of all literature in the series
     *
     * @return a list-String of all literature in the series
     */
    @Override
    public String getDetailsAsString() {
        String seriesList = "";
        for (Map.Entry<Integer, SerialLiterature> entry : issues.entrySet()) {
            seriesList = seriesList + entry.getValue().getDetailsAsString();
        }
        return seriesList;
    }
}
