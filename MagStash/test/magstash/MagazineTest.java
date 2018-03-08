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
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        String expResult = "-------------------------\nName\nNumber: 1\nRelease date: 3/4/5\n-------------------------";
        String result = testMagazine.getDetailsAsString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeries method, of class Magazine.
     */
    @Test
    public void testGetSeries() {
        System.out.println("getSeries");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        String expResult = "Name";
        String result = testMagazine.getSeries();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeries method, of class Magazine.
     */
    @Test
    public void testSetSeries() {
        System.out.println("setSeries");
        String newSeries = "NewSeries";
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        testMagazine.setSeries(newSeries);
    }

    /**
     * Test of getPublisher method, of class Magazine.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        String expResult = "Publisher";
        String result = testMagazine.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPublisher method, of class Magazine.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String newPublisher = "newPublisher";
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        testMagazine.setPublisher(newPublisher);
    }

    /**
     * Test of getNumber method, of class Magazine.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        int expResult = 1;
        int result = testMagazine.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class Magazine.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int newNumber = 5;
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        testMagazine.setNumber(newNumber);
        assertEquals(newNumber, testMagazine.getNumber());
    }

    /**
     * Test of getReleasesPerYear method, of class Magazine.
     */
    @Test
    public void testGetReleasesPerYear() {
        System.out.println("getReleasesPerYear");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        int expResult = 2;
        int result = testMagazine.getReleasesPerYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReleasesPerYear method, of class Magazine.
     */
    @Test
    public void testSetReleasesPerYear() {
        System.out.println("setReleasesPerYear");
        int releasesPerYear = 0;
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        testMagazine.setReleasesPerYear(releasesPerYear);
    }

    /**
     * Test of getYear method, of class Magazine.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        int expResult = 3;
        int result = testMagazine.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Magazine.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        int expResult = 4;
        int result = testMagazine.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Magazine.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Magazine testMagazine = new Magazine("Name", "Publisher", 1, 2, 3, 4, 5);
        int expResult = 5;
        int result = testMagazine.getDay();
        assertEquals(expResult, result);
    }

}
