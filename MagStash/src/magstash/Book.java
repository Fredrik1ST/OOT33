/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstash;

/**
 *
 * @author Fredrik
 */
public class Book extends Literature {

    /**
     * Constructor for Book.
     *
     * @param title the book title
     * @param publisher the book's publisher
     * @param year the book's year of release
     * @param month the book's month of release
     * @param day the book's day of release
     */
    public Book(String title, String publisher, int year, int month, int day) {
        super(title, publisher, year, month, day);
    }

    /**
     * Returns a formatted string of the details of this book.
     * Date format is in YYYY/MM/DD.
     *
     * @return the details as a formatted string.
     */
    @Override
    public final String getDetailsAsString() {
        return "-----------------------\n"
                + this.getYear() + "/" + this.getMonth() + "/" + this.getDay()
                + "\n Nummer: ";
    }

}
