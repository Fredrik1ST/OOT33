package magstash;

import ui.ApplicationUI;

/**
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 * @version 0.2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LiteratureRegister litCache = new LiteratureRegister();
        ApplicationUI appUI = new ApplicationUI();
        appUI.setProductType("magazine");
        appUI.litReg = litCache;
        appUI.start();
    }

}
