package literature;

/**
 * A superclass for all literature. Has all the information that is common to
 * all literatures. In reality, Literature only holds date-treating methods, but
 * we believe it's worth it to avoid rewriting them whenever creating new forms
 * of media.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Literature {

    private final String title; 
    private final String publisher;
    private String genre;
    

    /**
     * Initialises Literature from a LocalDate object.
     * Automatically handles incorrect dates,
     * such as 2005/16/-2 through LocalDate.
     *
     * @param title title of the piece.
     * @param publisher publisher of the piece.
     * @param releaseDate the release date of the piece.
     * Throws a DateTimeException if the date is incorrect.
     */
    public Literature(final String title, 
            final String publisher, final String genre) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    public final String getPublisher() {
        return this.publisher;
    }
    
    /**
     * Gets the genre
     * @return the genre
     */
    public final String getGenre() {
        return this.genre;
    }

    /**
     * Abstract class to give out the details of the piece.
     *
     * @return all details of the piece as string.
     */
    abstract public String getDetailsAsString();
    
    /**
     * Overrides the method "equals". Necessary for comparing literature types.
     * @param b the literature to be compared to
     * @return TRUE if the objects are equal
     */
    @Override
    abstract public boolean equals(Object b);
}
