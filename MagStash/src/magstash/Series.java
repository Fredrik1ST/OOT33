package magstash;

/**
 * A superclass for series. Its purpose is to keep general information that all
 * series have, whether book series, magazines, or other, in order to keep code 
 * cleaner. 
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 2018/03/19
 */
public class Series {
    private String seriesName;
    private String publisher;
    private String genre;
    
    /**
     * Initializes the series with all fields filled.
     * @param seriesName the name of the series
     * @param publisher the publisher of the series
     * @param genre the genre of the series
     */
    public Series(String seriesName, String publisher, String genre){
        this.seriesName = seriesName;
        this.publisher = publisher;
        this.genre = genre;
    }

    /**
     * Returns the series name.
     * @return the seriesName
     */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * Changes the series name.
     * @param seriesName the seriesName to set
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    /**
     * Returns the genre of this series.
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Changes this series genre.
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns the publisher of the series.
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Changes the publisher of the series.
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
