//TODO Make it so that no Null ever sets foot in here!
//We're getting nullpointer exceptions from 

package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import magstash.LiteratureCache;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author asty
 * @version 0.2
 */
public class ApplicationUI {
    // Name of the currently displayed literature type (eg. book, magazine)
    // Set with "setProductType()"
    private String product = "magazine";

    public LiteratureCache literatureCache;

    // The menu that will be displayed. 
    private String[] menuItems
            = {
                "1. List all " + product + " series",
                "2. Add new " + product + "",
                "3. Add new " + product + " series",
                "4. Find a " + product + " by name",};

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewProduct();
                        break;

                    case 3:
                        this.addNewProductSeries();
                        break;
                        
                    case 4:
                        this.findProductByName();
                        break;

                    case 5:
                        System.out.println(
                                "\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println(
                        "\nERROR: Please provide a number between 1 and " 
                                + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException if user enters an invalid number/menu
     * choice
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Application v0.2 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---
    /**
     * Initialises the application. Typically you would create the
     * LiteratureRegistrer-instance here
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register (MagazineStand).
     */
    private void listAllProducts() {
        System.out.println("\nYou selected \"List all " + product + "s\".");
        System.out.println(literatureCache.listAllMagazineSeries() + "\n");
    }

    /**
     * Add a new piece of literature to the literature register.
     */
    private void addNewProduct() {
        boolean running = true;

        Scanner reader = new Scanner(System.in);
        String seriesName = "";
        int newReleaseNr;
        int newYear;
        int newMonth;
        int newDay;

        System.out.println("\nYou selected \"Add new " + product + "\".");

        
            System.out.println("Enter name of series: ");
            seriesName = reader.nextLine();
            while (seriesName.equals("") || !literatureCache.hasMagazineSeries(seriesName)) {
                if (running) {
                    String answer;
                    System.out.println("Series does not exist in the register. "
                            + "Do you want to add a new series? (Y/N)");
                    answer = reader.nextLine();
                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                        addNewProductSeries();
                    }
                    else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                        System.out.println("Returning to menu...");
                        running = false;
                    
                }
        }
                else {
                    break;
                }
            }

        try {
            System.out.println("Enter release number: ");
            newReleaseNr = reader.nextInt();
            System.out.println("Enter year of release (YYYY): ");
            newYear = reader.nextInt();
            System.out.println("Enter month of release (MM): ");
            newMonth = reader.nextInt();
            System.out.println("Enter day of release (DD): ");
            newDay = reader.nextInt();

            // Checks if the magazine is already in the stand. Adds if not.
            
            if (literatureCache.getMagazineSeries(seriesName).
                    addMagazine(newYear, newMonth, newDay, newReleaseNr)) {
                System.out.println("\nThe magazine has been added.");
            } else {
                System.out.println("\nThe magazine already exists");
            }
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR: Expected an integer. Returning to menu...");
        }

    }
    
    /**
     * Adds a new literature series that can then be populated with literature.
     */
    private void addNewProductSeries() {
        Scanner reader = new Scanner(System.in);
        String seriesName ="";
        int releasesPerYear = 0;
        String publisher="";
        String genre="";
        
        System.out.println("\nYou selected \"Add new " + product + " series\".");
        
        while (seriesName.equals("")){
            System.out.println("Enter name of series: ");
            seriesName = reader.nextLine();
        }
        while (publisher.equals("")){
            System.out.println("Enter publisher: ");
            publisher = reader.nextLine();
        }
        while (genre.equals("")){
            System.out.println("Enter genre: ");
            genre = reader.nextLine();
        }
        
        try {
            System.out.println("Enter number of releases per year:" );
            releasesPerYear = reader.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR: Expected an integer. Returning to menu...");
        }
        
        literatureCache.addMagazineSeries(seriesName, releasesPerYear, publisher, genre);
    }

    /**
     * Find and display the literature's fields 
     * based on its series' name and release number.
     */
    private void findProductByName() {
        try {
            Scanner reader = new Scanner(System.in);
            String seriesName = "";
            int releaseNr;

            System.out.println("\nYou selected \"Find " + product + " by name\".");

            while (seriesName.equals("")) {
                System.out.println("Enter name of series: ");
                seriesName = reader.nextLine();
            }
            System.out.println("Enter release number: ");
            releaseNr = reader.nextInt();

            if (literatureCache.getMagazineSeries(seriesName).listByReleaseNr(releaseNr) == null) {
                String answer = "";
                System.out.println("Could not find the magazine."
                        + " Do you want to list all magazines instead? (Y/N)");
                while (answer.equals("")) {
                    answer = reader.nextLine();
                }
                if (answer.toLowerCase().startsWith("y")) {
                    System.out.println(literatureCache.
                            getMagazineSeries(seriesName).listAllMagazines());
                } else {
                    System.out.println("\nReturning to menu...");
                }
            } else {
                System.out.println(literatureCache.getMagazineSeries(seriesName).listByReleaseNr(releaseNr));
            }
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR: Expected an integer. Returning to menu...");
        }
    }
    
    /**
     * Name what type of product the UI is going to display.
     * @param product the type of literature the UI will display (e.g. books)
     */
    public void setProductType (String product) {
        this.product = product;
    }

}
