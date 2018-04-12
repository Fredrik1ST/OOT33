/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import literature.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fredrik
 */
public class SerialLiteratureTest {

    public SerialLiteratureTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        SerialLiterature m = new Magazine("S&H", "publisher", 1111, 1, 11, 1);
        SerialLiterature j = new Journal("Time", "publisher", 111, 1, 11, 1);
        SerialLiterature l = new Newspaper("SMP", "publisher", 1111, 1, 11, 1);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Try implementing SerialLiterature
     */
    public class SerialLiteratureSubClass extends SerialLiterature {

        public SerialLiteratureSubClass() {
            super("title", "publisher", 1814, 5, 17, 1);
        }

        public String getDetailsAsString() {
            return "No details, no worries. YOLO!";
        }
    }

}
