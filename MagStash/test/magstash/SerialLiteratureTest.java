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
public class SerialLiteratureTest {
    
    public SerialLiteratureTest() {
    }

    /**
     * Test of compareTo method, of class SerialLiterature.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        SerialLiterature sl = null;
        SerialLiterature instance = null;
        int expResult = 0;
        int result = instance.compareTo(sl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReleaseNr method, of class SerialLiterature.
     */
    @Test
    public void testGetReleaseNr() {
        System.out.println("getReleaseNr");
        SerialLiterature instance = null;
        int expResult = 0;
        int result = instance.getReleaseNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
