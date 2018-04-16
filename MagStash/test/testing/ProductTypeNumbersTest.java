package testing;

import handling.ProductTypeNumbers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Fredrik
 */
public class ProductTypeNumbersTest {
    
    ProductTypeNumbers typeList = new ProductTypeNumbers();
    
    public ProductTypeNumbersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ProductTypeNumbers typeList = new ProductTypeNumbers();
        
    }

    /**
     * Test of display method, of class ProductTypeNumbers.
     */
    @Test
    public void testDisplayTypes() {
        
        System.out.println("List length: " + typeList.getListLength()
                + "\n" + typeList.displayTypes());

    }
    
}