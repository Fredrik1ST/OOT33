package entries;

/**
 * A superclass for all literature. Has all the information that is common to
 * all literatures. In reality, Entry only holds date-treating methods, but
 * we believe it's worth it to avoid rewriting them whenever creating new forms
 * of media.
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public abstract class Entry {

    private final String title;
    private final String publisher;
    private final String genre;


    /**
     * Initialises Literature from a LocalDate object.
     * Automatically handles incorrect dates,
     * such as 2005/16/-2 through LocalDate.
     *
     * @param title title of the piece.
     * @param publisher publisher of the piece.
     * @param genre genre of the piece
     */
    public Entry(String title,
            String publisher, String genre) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
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
     *
     * @return the genre
     */
    public final String getGenre() {
        return this.genre;
    }

    /**
     * Overrides the method "equals". Necessary for comparing literature types.
     *
     * @param b the literature to be compared to
     * @return TRUE if the objects are equal
     */
    @Override
    abstract public boolean equals(Object b);
}
