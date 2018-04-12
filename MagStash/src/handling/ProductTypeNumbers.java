package handling;

/**
 * PROPOSAL : use this class to keep track of standards,
 * like the product type numbers, so as to keep them consistent between classes
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 */
public class ProductTypeNumbers {

    /**
     * EXAMPLE TAKEN FROM CLASS "LIBRARIAN"
     * Designates a number (through array indexing) to each product type.
     * These numbers are universally used to present the product types.
     */
    public final String[] productTypes
            = {
                "type error", /*     0 */
                "book", /*           1 */
                "magazine", /*       2 */
                "journal", /*        3 */
                "newspaper", /*      4 */};
    
    public void display() {
System.out.println(productTypes);
}
    
}

