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
            final int year, final int month, final int day, 
            final String author, final int edition) {
        super(title, publisher, genre, year, month, day, edition);
        this.author = author;

    }

    /**
     * Returns the author of the book
     * @return the author of the book
     */
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

        return "\n-----------------------\n" + this.getTitle()
                + " - " + this.getEdition() + ". edition"
                + "\nBook published by " + this.getPublisher() + "\n"
                + "Written by " + this.getAuthor() + "\n"
                + "Genre: " + this.getGenre() + "\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay();
    }

    @Override
    public int hashCode() {
        return (this.getTitle().length() * 17
                + this.getPublisher().length() * 31
                + this.getAuthor().length() * 17
                + this.getGenre().length() * 3
                + this.getYear() * 31
                + this.getMonth() * 17
                + this.getDay() * 31
                + this.getEdition() * 17);
    }
}
