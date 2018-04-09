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
        LiteratureCache litCache = new LiteratureCache();
        ApplicationUI appUI = new ApplicationUI();
        appUI.setProductType("magazine");
        appUI.literatureCache = litCache;
        appUI.start();
    }

}
