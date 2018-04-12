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
public class SeriesTest {
    
    public SeriesTest() {
    }

    /**
     * Test of getSeriesName method, of class Series.
     */
    @Test
    public void testGetSeriesName() {
        System.out.println("getSeriesName");
        Series instance = null;
        String expResult = "";
        String result = instance.getSeriesName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeriesName method, of class Series.
     */
    @Test
    public void testSetSeriesName() {
        System.out.println("setSeriesName");
        String seriesName = "";
        Series instance = null;
        instance.setSeriesName(seriesName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenre method, of class Series.
     */
    @Test
    public void testGetGenre() {
        System.out.println("getGenre");
        Series instance = null;
        String expResult = "";
        String result = instance.getGenre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenre method, of class Series.
     */
    @Test
    public void testSetGenre() {
        System.out.println("setGenre");
        String genre = "";
        Series instance = null;
        instance.setGenre(genre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublisher method, of class Series.
     */
    @Test
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Series instance = null;
        String expResult = "";
        String result = instance.getPublisher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublisher method, of class Series.
     */
    @Test
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "";
        Series instance = null;
        instance.setPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class SeriesImpl extends Series {

        public SeriesImpl() {
            super("", "", "");
        }

        public String getProductsAsString() {
            return "";
        }
    }
    
}
