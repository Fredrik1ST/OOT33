package magstash;

import magstash.ui.ApplicationUI;

/**
 * @author Hans Christian Haugan Finnson, Fredrik Siem Taklo, Magnus Renaa Kjørseng
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MagazineStand magStand = new MagazineStand();
        ApplicationUI appUI = new ApplicationUI();
        appUI.currentMagStand = magStand;
        appUI.start();
    }

}
