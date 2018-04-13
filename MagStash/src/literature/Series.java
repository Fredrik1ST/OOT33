package literature;

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

    /**
     * Initializes the series with all fields filled.
     *
     * @param title the name of the series
     * @param publisher the publisher of the series
     * @param genre the genre of the series
     */
    public Series(String title, String publisher, String genre) {
        super(title, publisher, genre);
    }

    abstract String getProductsAsString();
}
