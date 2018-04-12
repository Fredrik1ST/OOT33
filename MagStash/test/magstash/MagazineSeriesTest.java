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
public class MagazineSeriesTest {
    
    public MagazineSeriesTest() {
    }

    /**
     * Test of addMagazine method, of class MagazineSeries.
     */
    @Test
    public void testAddMagazine_Magazine() {
        System.out.println("addMagazine");
        Magazine magazine = null;
        MagazineSeries instance = null;
        boolean expResult = false;
        boolean result = instance.addMagazine(magazine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMagazine method, of class MagazineSeries.
     */
    @Test
    public void testAddMagazine_6args() {
        System.out.println("addMagazine");
        String title = "";
        String publisher = "";
        int year = 0;
        int month = 0;
        int day = 0;
        int releaseNr = 0;
        MagazineSeries instance = null;
        boolean expResult = false;
        boolean result = instance.addMagazine(title, publisher, year, month, day, releaseNr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeMagazine method, of class MagazineSeries.
     */
    @Test
    public void testRemoveMagazine() {
        System.out.println("removeMagazine");
        Magazine magazine = null;
        MagazineSeries instance = null;
        boolean expResult = false;
        boolean result = instance.removeMagazine(magazine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfMagazines method, of class MagazineSeries.
     */
    @Test
    public void testGetNumberOfMagazines() {
        System.out.println("getNumberOfMagazines");
        MagazineSeries instance = null;
        int expResult = 0;
        int result = instance.getNumberOfMagazines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMagazine method, of class MagazineSeries.
     */
    @Test
    public void testGetMagazine() {
        System.out.println("getMagazine");
        Magazine magazine = null;
        MagazineSeries instance = null;
        Magazine expResult = null;
        Magazine result = instance.getMagazine(magazine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductsAsString method, of class MagazineSeries.
     */
    @Test
    public void testGetProductsAsString() {
        System.out.println("getProductsAsString");
        MagazineSeries instance = null;
        String expResult = "";
        String result = instance.getProductsAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listByReleaseNr method, of class MagazineSeries.
     */
    @Test
    public void testListByReleaseNr() {
        System.out.println("listByReleaseNr");
        int releaseNr = 0;
        MagazineSeries instance = null;
        String expResult = "";
        String result = instance.listByReleaseNr(releaseNr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMagazineDate method, of class MagazineSeries.
     */
    @Test
    public void testSetMagazineDate() {
        System.out.println("setMagazineDate");
        Magazine magazine = null;
        LocalDate newDate = null;
        MagazineSeries instance = null;
        instance.setMagazineDate(magazine, newDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMagazineReleaseNumber method, of class MagazineSeries.
     */
    @Test
    public void testSetMagazineReleaseNumber() {
        System.out.println("setMagazineReleaseNumber");
        Magazine magazine = null;
        int releaseNr = 0;
        MagazineSeries instance = null;
        instance.setMagazineReleaseNumber(magazine, releaseNr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllMagazines method, of class MagazineSeries.
     */
    @Test
    public void testListAllMagazines() {
        System.out.println("listAllMagazines");
        MagazineSeries instance = null;
        String expResult = "";
        String result = instance.listAllMagazines();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReleasesPerYear method, of class MagazineSeries.
     */
    @Test
    public void testGetReleasesPerYear() {
        System.out.println("getReleasesPerYear");
        MagazineSeries instance = null;
        int expResult = 0;
        int result = instance.getReleasesPerYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReleasesPerYear method, of class MagazineSeries.
     */
    @Test
    public void testSetReleasesPerYear() {
        System.out.println("setReleasesPerYear");
        int releasesPerYear = 0;
        MagazineSeries instance = null;
        instance.setReleasesPerYear(releasesPerYear);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
