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
public class JournalTest {
    
    public JournalTest() {
    }

    /**
     * Test of getDetailsAsString method, of class Journal.
     */
    @Test
    public void testGetDetailsAsString() {
        System.out.println("getDetailsAsString");
        Journal instance = null;
        String expResult = "";
        String result = instance.getDetailsAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
