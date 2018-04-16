/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entries;

/**
 *
 * @author Fredrik
 */
public class Book extends Literature {

    private String author = "";
    int edition;

    /**
     * Constructor for Book.
     *
     * @param title the book title
     * @param publisher the book's publisher
     * @param genre the book's genre
     * @param year the book's year of release
     * @param month the book's month of release
     * @param day the book's day of release
     * @param releaseNr the book's release number, 0 for not in series
     * @param author the book's author
     * @param edition the book's edition
     */
    public Book(String title, String publisher, String genre,
            int year, int month, int day, int releaseNr, String author, int edition) {
        super(title, publisher, genre, year, month, day, releaseNr);
        this.author = author;
        this.edition = edition;
    }

    public String getAuthor() {
        return this.author;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return this.edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

}
