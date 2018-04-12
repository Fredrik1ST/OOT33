/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class ApplicationUITest {
    
    public ApplicationUITest() {
    }

    /**
     * Test of start method, of class ApplicationUI.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        ApplicationUI instance = new ApplicationUI();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductType method, of class ApplicationUI.
     */
    @Test
    public void testSetProductType() {
        System.out.println("setProductType");
        String product = "";
        ApplicationUI instance = new ApplicationUI();
        instance.setProductType(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
