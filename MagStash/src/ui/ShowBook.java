package ui;

import literature.Book;

/**
 * A display method for Book objects. Requires Book class to function.
 Exists to increase cohesion and decrease coupling.
 *
 * @author Magnus
 */
public class ShowBook {

    /**
     * Takes in a Book and gives out a formatted string.
     * @param book the book to get information from
     * @return formatted string with information about book
     */
    public final String getDetailsAsString(Book book) {
        return "\n-----------------------\n" + book.getTitle()
                + " - " + book.getEdition() + ". edition"
                + "\nBook published by " + book.getPublisher() + "\n"
                + "Written by " + book.getAuthor() + "\n"
                + "Genre: " + book.getGenre() + "\n"
                + book.getYear() + "/" + book.getMonth() + "/" + book.getDay();
    }
}
