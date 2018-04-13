/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literature;

/**
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Book extends StandaloneLiterature {

    private String author = "";

    /**
     * Constructor for Book.
     *
     * @param title the book title
     * @param publisher the book's publisher
     * @param year the book's year of release
     * @param month the book's month of release
     * @param day the book's day of release
     * @param author the book's author
     */
    public Book(final String title, final String publisher, final String genre,
            final int year, final int month, final int day, final String author) {
        super(title, publisher, genre, year, month, day);
        this.author = author;

    }

    
    public String getAuthor() {
        return this.author;
    }
    /**
     * Returns a formatted string of the details of this book.
     * Date format is in YYYY/MM/DD.
     *
     * @return the details as a formatted string.
     */
    @Override
    public final String getDetailsAsString() {

        return "\n-----------------------\n'" + this.getTitle() 
                + "\nPublished by " + this.getPublisher() + "\n"
                + "Written by " + this.getAuthor() + "\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay();
    }

}
