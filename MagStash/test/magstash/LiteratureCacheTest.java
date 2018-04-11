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
public class LiteratureCacheTest {
    private String testSeries = "The Bug";
    private String testPublisher = "A programmer";
    private String testGenre = "Horror";
    
    public LiteratureCacheTest() {
        
    }

    /**
     * Test of addMagazineSeries method, of class SeriesRegister.
     */
    @Test
    public void testAddMagazineSeries() {
        System.out.println("addMagazineSeries");
        String seriesName = "";
        int releasesPerYear = 0;
        String publisher = "";
        String genre = "";
        SeriesRegister instance = new SeriesRegister();
        boolean expResult = false;
        boolean result = instance.addMagazineSeries(seriesName, releasesPerYear, publisher, genre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMagazineSeries method, of class SeriesRegister.
     */
    @Test
    public void testGetMagazineSeries() {
        System.out.println("getMagazineSeries");
        String seriesName = "";
        SeriesRegister instance = new SeriesRegister();
        MagazineSeries expResult = null;
        MagazineSeries result = instance.getMagazineSeries(seriesName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllMagazineSeries method, of class SeriesRegister.
     */
    @Test
    public void testListAllMagazineSeries() {
        System.out.println("listAllMagazineSeries");
        SeriesRegister instance = new SeriesRegister();
        String expResult = "";
        String result = instance.listAllMagazineSeries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasMagazineSeries method, of class SeriesRegister.
     */
    @Test
    public void testHasMagazineSeries() {
        System.out.println("Test for hasMagazineSeries:\n");
        SeriesRegister instance = new SeriesRegister();
        instance.addMagazineSeries(testSeries, 12, testPublisher, testGenre);
        
        boolean expResult = true;
        boolean result = instance.hasMagazineSeries(testSeries);
        assertEquals(expResult, result);
       
    }
    
}
