/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magstash;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class LiteratureTest {
    
    public LiteratureTest() {
    }

    /**
     * Test of getYear method, of class Literature.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Literature instance = null;
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonth method, of class Literature.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Literature instance = null;
        int expResult = 0;
        int result = instance.getMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDay method, of class Literature.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Literature instance = null;
        int expResult = 0;
        int result = instance.getDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Literature.
     */
    @Test
    public void testSetDate_3args() {
        System.out.println("setDate");
        int year = 0;
        int month = 0;
        int day = 0;
        Literature instance = null;
        instance.setDate(year, month, day);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Literature.
     */
    @Test
    public void testSetDate_LocalDate() {
        System.out.println("setDate");
        LocalDate newDate = null;
        Literature instance = null;
        instance.setDate(newDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
