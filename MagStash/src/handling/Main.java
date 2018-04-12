package handling;

import ui.ApplicationUI;

/**
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.3
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        ApplicationUI appUI = new ApplicationUI();
        appUI.setProductType("item");
        appUI.start();
    }

}
