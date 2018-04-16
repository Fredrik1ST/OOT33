package testing;

import handling.ProductNumbers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Fredrik
 */
public class ProductTypeNumbersTest {
    
    ProductNumbers typeList = new ProductNumbers();
    
    public ProductTypeNumbersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ProductNumbers typeList = new ProductNumbers();
        
    }

    /**
     * Test of display method, of class ProductNumbers.
     */
    @Test
    public void testDisplayTypes() {
        
        System.out.println("List length: " + typeList.getListLength()
                + "\n" + typeList.displayTypes());

    }
    
}