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
        Literature m = new Magazine("Se og Hør", "publisher", "horror", 
                111, 1, 11, 1);
        Literature j = new Journal("Time", "publisher", "genre", 
                111, 1, 11, 1);
        Literature l = new Newspaper("SMP", "publisher", "genre", 
                1111, 1, 11, 1);
    }


    /**
     * Try implementing Literature
     */
    public class SerialLiteratureSubClass extends Literature {

        public SerialLiteratureSubClass() {
            super("title", "publisher", "genre", 1814, 5, 17, 1);
        }

        @Override
        public String getDetailsAsString() {
            return "No details, no worries. YOLO!";
        }
    }

}
