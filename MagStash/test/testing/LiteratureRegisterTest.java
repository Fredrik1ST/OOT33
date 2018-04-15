/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import handling.LiteratureRegister;
import literature.Literature;
import literature.SerialLiterature;
import literature.Book;
import literature.Magazine;
import literature.Journal;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashSet;
import literature.Newspaper;

/**
 *
 * @author Fredrik
 */
public class LiteratureRegisterTest {

    LiteratureRegister litReg;
    Literature b;
    Literature m;
    Literature j;
    Literature n;

    public LiteratureRegisterTest() {
        b = new Book("Book", "publisher", "genre",
                1999, 11, 1, "author");
        m = new Magazine("Magazine", "publisher", "horror",
                111, 1, 11, 1);
        j = new Journal("Journal", "publisher", "genre",
                111, 1, 11, 1);
        n = new Newspaper("News", "publisher", "genre",
                1111, 1, 11, 1);
    }

    /**
     * Test of addLiterature method, of class LiteratureRegister.
     */
    @Test
    public void testAddRemoveLiterature() {
        litReg = new LiteratureRegister();
        boolean itWorks = false;
        System.out.println("Let's try adding stuff without breaking stuff:");

        itWorks = litReg.addLiterature(b);
        itWorks = litReg.addLiterature(m);
        itWorks = litReg.addLiterature(j);
        itWorks = litReg.addLiterature(n);
        
        assertEquals(itWorks, true);
    }

    @Test
    public void compareTwoTypes() {
        System.out.println("Compare two types of literature");
        LiteratureRegister testReg = new LiteratureRegister();

        SerialLiterature m = new Magazine("Item", "Pub", ":)", 1999, 11, 1, 1);
        SerialLiterature j = new Journal("Item", "Pub", ":)", 1999, 11, 1, 1);
        SerialLiterature m2 = new Magazine("Item", "Pub", ":)", 1999, 11, 1, 1);

        boolean expResult = true;
        boolean result = (m.equals(m2));
        assertEquals(expResult, result);

    }

}
