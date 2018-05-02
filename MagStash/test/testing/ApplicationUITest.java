/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import entries.*;
import handling.LiteratureRegister;
import ui.ApplicationUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;
import ui.Parser;
import ui.show.ShowBook;
import ui.show.ShowJournal;
import ui.show.ShowMagazine;
import ui.show.ShowNewspaper;
import ui.show.ShowSeries;

/**
 *
 * @author Fredrik
 */
public class ApplicationUITest {

    Parser parser;
    ApplicationUI ui;
    LiteratureRegister litReg;

    public ApplicationUITest() {
        parser = new Parser();
        ui = new ApplicationUI();
        litReg = new LiteratureRegister();
    }

    /**
     * Prints details of given Literature
     */
    public void printDetails(Entry l) {
        if (l instanceof Series) {
            Series s = (Series) l;
            System.out.print(ShowSeries.getDetailsAsString(s));
        } else if (l instanceof Book) {
            Book b = (Book) l;
            System.out.print(ShowBook.getDetailsAsString(b));
        } else if (l instanceof Magazine) {
            Magazine m = (Magazine) l;
            System.out.print(ShowMagazine.getDetailsAsString(m));
        } else if (l instanceof Journal) {
            Journal j = (Journal) l;
            System.out.print(ShowJournal.getDetailsAsString(j));
        } else if (l instanceof Newspaper) {
            Newspaper np = (Newspaper) l;
            System.out.print(ShowNewspaper.getDetailsAsString(np));
        }
    }

    /**
     * Makes an indexed list of Literature that the user can choose from.
     * Literature and indexes are made from whatever ArrayList is provided.
     * Entry chosen by the user can be used to delete issues or expand series.
     *
     * @return the Entry chosen by the user
     */
    @Test
    public void listItem() {
        litReg.addLiterature(new Book(
                "A book", "some publisher", "a genre", 1995, 11, 18, 0, "author", 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 2));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 3));
        Series series = new MagazineSeries(
                "A magazine series", "some publisher", "a genre", 3);
        litReg.addLiterature(series);

        System.out.println("Get by title (litReg): \n");
        List<Entry> entries1 = litReg.getByTitle("magazine");
        ArrayList<Entry> entries2 = new ArrayList<Entry>();
        ArrayList<Entry> entries3 = new ArrayList<Entry>();
        for (Entry e : entries1) {
            System.out.print(e.getTitle());
            if (e instanceof Literature) {
                System.out.print(" #" + ((Literature) e).getReleaseNr());
                entries2.add(e);
            }
            System.out.print("\n");
        }
        // THIS DOES NOT WORK FOR LISTING
        System.out.println("\nExperimental loop: ");
        for (int i = 0; i == entries2.size(); i++) {
            Entry l = entries2.get(i);
            System.out.println("#" + (i + 1) + ": "
                    + l.getTitle());
            printDetails(entries2.get(i));

        }
        System.out.println("Loop done... \n");
        for (Entry e : entries2) {
            System.out.print(e.getTitle());
            if (e instanceof Literature) {
                System.out.print(" #" + ((Literature) e).getReleaseNr());
            }
            System.out.print("\n");
        }
    }
}
