/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstash;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class LiteratureRegisterTest {

    public LiteratureRegisterTest() {
    }

    /**
     * Test of addLiterature method, of class LiteratureRegister.
     */
    @Test
    public void testAddLiterature() {
        System.out.println("addLiterature");
        Literature l = new Book("title", "publisher", 1999, 11, 1);
        LiteratureRegister instance = new LiteratureRegister();
        instance.addLiterature(l);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByTitle method, of class LiteratureRegister.
     */
    @Test
    public void testGetByTitle() {
        System.out.println("getByTitle");
        String title = "";
        LiteratureRegister instance = new LiteratureRegister();
        Literature expResult = null;
        Literature result = instance.getByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByPublisher method, of class LiteratureRegister.
     */
    @Test
    public void testGetByPublisher() {
        System.out.println("getByPublisher");
        String publisher = "";
        LiteratureRegister instance = new LiteratureRegister();
        Literature expResult = null;
        Literature result = instance.getByPublisher(publisher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void compareTwoTypes() {
        System.out.println("Compare two types of literature");
        LiteratureRegister testReg = new LiteratureRegister();

        SerialLiterature m = new Magazine("Item", "Pub", 1999, 11, 1, 1);
        SerialLiterature j = new Journal("Item", "Pub", 1999, 11, 1, 1);

        boolean expResult = false;
        boolean result = (m.equals(j));
        assertEquals(expResult, result);

    }

}
