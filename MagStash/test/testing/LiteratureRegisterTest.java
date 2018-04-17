package testing;

import entries.*;
import handling.LiteratureRegister;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class LiteratureRegisterTest {

    LiteratureRegister litReg;
    Entry b;
    Entry m;
    Entry j;
    Entry n;

    public LiteratureRegisterTest() {
        b = new Book("Book", "publisher", "genre",
                1999, 11, 1, 1, "author", 1);
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

        Literature m = new Magazine("Item", "Pub", ":)", 1999, 11, 1, 1);
        Literature j = new Journal("Item", "Pub", ":)", 1999, 11, 1, 1);
        Literature m2 = new Magazine("Item", "Pub", ":)", 1999, 11, 1, 1);

        boolean expResult = true;
        boolean result = (m.equals(m2));
        assertEquals(expResult, result);

    }

}
