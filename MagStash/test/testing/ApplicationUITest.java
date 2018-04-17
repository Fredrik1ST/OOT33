/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import entries.*;
import handling.LiteratureRegister;
import java.util.ArrayList;
import java.util.HashSet;
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
    
    public ApplicationUITest() {
        parser = new Parser();
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
     * @return the Entry chosen by the user
     */
    public Entry chooseItem(ArrayList<Entry> entries) { 
        int userChoice = -1;
        Entry chosenEntry;
        
        System.out.println("Here are your choices:\n");
        
        // Achtung! The printed list starts at 1 instead of 0!
         for (int i = 0; i == entries.size(); i++) {
            Entry l = entries.get(i);
            System.out.println("#" + (i + 1) + ":");
            printDetails(entries.get(i));
    }
         System.out.println("Please select an item\n");
         userChoice = parser.nextInt();
         chosenEntry = entries.get((userChoice-1));
         
         return chosenEntry;
         
}
}
