/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handling;

import java.util.ArrayList;
import literature.*;
import literature.SerialLiterature;
import literature.StandaloneLiterature;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class LibrarianTest {

    LiteratureRegister litReg;
    Literature b;
    Literature m;
    Literature j;
    Literature n;

    public LibrarianTest() {
        litReg = new LiteratureRegister();

        b = new Book("Markens Grøde", "publisher", "genre",
                1999, 11, 1, "author", 1);
        m = new Magazine("A-magasinet", "publisher", "horror",
                111, 1, 11, 1);
        j = new Journal("A-magasinet", "publisher", "genre",
                111, 1, 11, 1);
        n = new Newspaper("Sunnmørsposten", "publisher", "genre",
                1111, 1, 11, 1);
    }

    @Test
    public void testAddSeries() {

    }

    @Test
    public void testPrintDetails() {
        ArrayList<Literature> issues = new ArrayList<>();
        issues.add(b);
        issues.add(m);
        issues.add(j);
        issues.add(n);

        String foundLiterature = "";
        for (Literature l : issues) {
            foundLiterature += l.getDetailsAsString();
        }
        System.out.println(foundLiterature);
    }

    @Test
    public void testCompareClasses() {
        assertEquals(true, (b instanceof Literature));
        assertEquals(false, (m instanceof Journal));
    }

    @Test
    public void testDeleteIssues() {
        litReg.addLiterature(b);
        System.out.println("\nContents before deletion: ");
        for (Literature l : litReg.getAllLiterature()) {
            System.out.println(l.getDetailsAsString());
        }
        litReg.removeLiterature(new Book("Markens Grøde", "publisher", "genre",
                1999, 11, 1, "author", 1));
        System.out.println("\nContents after deletion: ");
        for (Literature l : litReg.getAllLiterature()) {
            System.out.println(l.getDetailsAsString()
                    + ProductTypeNumbers.getProductTypes()[1]);
        }
    }
}
