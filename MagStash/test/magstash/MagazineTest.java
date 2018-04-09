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
public class MagazineTest {
    
    public MagazineTest() {
    }

    /**
     * Test of getDetailsAsString method, of class Magazine.
     */
    @Test
    public void testGetDetailsAsString() {
        System.out.println("getDetailsAsString");
        Magazine instance = null;
        String expResult = "";
        String result = instance.getDetailsAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReleaseNr method, of class Magazine.
     */
    @Test
    public void testGetReleaseNr() {
        System.out.println("getReleaseNr");
        Magazine instance = null;
        int expResult = 0;
        int result = instance.getReleaseNr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReleaseNr method, of class Magazine.
     */
    @Test
    public void testSetReleaseNr() {
        System.out.println("setReleaseNr");
        int releaseNr = 0;
        Magazine instance = null;
        instance.setReleaseNr(releaseNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
