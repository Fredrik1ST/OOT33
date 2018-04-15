package handling;

/**
 * PROPOSAL : use this class to keep track of standards,
 * like the product type numbers, so as to keep them consistent between classes
 *
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 */
public class ProductTypeNumbers {

    /**
     * @field productTypes
     * Designates a number (through array indexing) to each product type.
     * These numbers are universally used to present the product types.
     */
    private static String[] productTypes;

    /**
     * Constructor for class ProductTypeNumbers.
     */
    public ProductTypeNumbers() {
        productTypes = new String[]{
            "type error", /*     0 */
            "book", /*           1 */
            "magazine", /*       2 */
            "journal", /*        3 */
            "newspaper", /*      4 */};
    }

    /**
     * Returns the product type number array.
     * @return the productTypeNumber array
     */
    public static String[] getProductTypes() {
        return productTypes;
    }
    
    /**
     * Returns the length of the array - 1, since 0 is never used.
     * @return the length of the productTypeNumber array - 1.
     */
    public int getListLength() {
        return (getProductTypes().length - 1);
    }

    /**
     * List all registered types of literature by number, starting at 1.
     *
     * @return a numbered list of existing literature types
     */
    public String displayTypes() {
        String typeList = "";

        for (int i = 1; i < getProductTypes().length; i++) {
            // Capitalises the first letter of each string
            String type = i + ": " 
                    + getProductTypes()[i].substring(0, 1).toUpperCase()
                    + getProductTypes()[i].substring(1);
            typeList = typeList + type + "\n";
        }

        return typeList;
    }

}
