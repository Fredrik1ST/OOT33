/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package literature;

/**
 *
 * @author Fredrik
 */
public class SerialBook extends SerialLiterature {

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
     * @param releaseNr the book's release number
     */
    public SerialBook(String title, String publisher, String genre,
            final int year, final int month, int day,
            final int releaseNr, final String author) {
        super(title, publisher, genre, year, month, day, releaseNr);
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
                + "#" + this.getReleaseNr()
                + "\nBook published by " + this.getPublisher() + "\n"
                + "Written by " + this.getAuthor() + "\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay();
    }

}
