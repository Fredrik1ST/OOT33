//TODO Make it so that no Null ever sets foot in here!
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import magstash.LiteratureRegister;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author asty
 * @version 0.2
 */
public class ApplicationUI {

    // Name of the product in the menu (eg. product, book, magazine)
    // Set with "setProductType()"
    private String product = "item";

    public LiteratureRegister litReg;

    /**
     * The start menu (Top layer).
     */
    private String[] startMenuItems
            = {
                "1. View & search for " + product + "s...",
                "2. Add " + product + "s...",};

    /**
     * The "view" menu. Shows what the user can choose to view.
     */
    private String[] viewMenuItems
            = {
                "1. List all literature",
                "2. Find literature by title & publisher",
                "3. Find literature by publisher",};

    /**
     * The "add" menu. Shows what the user can add to the regiter.
     */
    private String[] addMenuItems
            = {
                "1. Add a book",
                "2. Add a magazine",
                "3. Add a journal",
                "4. Add a newspaper",
                "5. Make a series of existing " + product + "s",};

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
                // Display the main menu
                int menuSelection = this.showMenu(startMenuItems);
                switch (menuSelection) {
                    case 1:

                        try {
                            // Display the "view" menu
                            menuSelection = this.showMenu(viewMenuItems);
                            switch (menuSelection) {
                                case 1:
                                    // "1. List all literature"
                                    break;

                                case 2:
                                    // 2. Find by title & publisher
                                    break;

                                case 3:
                                    // 3. Find by publisher
                                    break;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println(
                                    "\nERROR: Please provide a number between 1 and "
                                    + this.viewMenuItems.length + "..\n");
                        }

                        break;

                    case 2:

                        try {
                            // Display the "add" menu
                            menuSelection = this.showMenu(addMenuItems);
                            switch (menuSelection) {
                                case 1:
                                    // Add a book
                                    break;

                                case 2:
                                    // Add a magazine
                                    break;

                                case 3:
                                    // Add a journal
                                    break;

                                case 4:
                                    // Add a newspaper
                                    break;

                                case 5:
                                    //Make a series out of existing literature
                                    break;

                                case 6:
                                    // Add to an existing series
                                    break;

                            }
                        } catch (InputMismatchException ime) {
                            System.out.println(
                                    "\nERROR: Please provide a number between 1 and "
                                    + this.addMenuItems.length + "..\n");
                        }
                        break;

                    case 3:
                        System.out.println(
                                "\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println(
                        "\nERROR: Please provide a number between 1 and "
                        + this.startMenuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @param currentMenu a String array of the user's choices in the menu
     * @return the menu number (between 1 and max menu item number) provided by
     * the user.
     * @throws InputMismatchException if user enters an invalid number/menu
     * choice
     */
    private int showMenu(String[] currentMenu) throws InputMismatchException {
        System.out.println("\n**** Application v0.2 ****\n");
        // Display the menu
        for (String menuItem : currentMenu) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = currentMenu.length + 1;
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

    //
    // ************************************************************************
    // The methods below this line are "helper"-methods, used from the menu
    // All these methods are made private, since they are only used by the menu
    // ************************************************************************
    //
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
        // TODO: DO SOMETHING!
    }

    /**
     * Add a new piece of literature to the literature register.
     */
    private void addNewProduct() {
        String productType;
        boolean running = true;

        Scanner reader = new Scanner(System.in);
        String title = "";
        int newReleaseNr;
        int newYear;
        int newMonth;
        int newDay;

        System.out.println("\nYou selected \"Add new " + product + "\".");
    }

    /**
     * Adds a new literature series that can then be populated with literature.
     */
    private void addNewProductSeries() {
        Scanner reader = new Scanner(System.in);
        String seriesName = "";
        int releasesPerYear = 0;
        String publisher = "";
        String genre = "";

        System.out.println("\nYou selected \"Add new " + product + " series\".");

        while (seriesName.equals("")) {
            System.out.println("Enter name of series: ");
            seriesName = reader.nextLine();
        }
        while (publisher.equals("")) {
            System.out.println("Enter publisher: ");
            publisher = reader.nextLine();
        }
        while (genre.equals("")) {
            System.out.println("Enter genre: ");
            genre = reader.nextLine();
        }
    }

    /**
     * Name what type of product the UI is going to display.
     *
     * @param product the type of literature the UI will display (e.g. books)
     */
    public void setProductType(String product) {
        this.product = product;
    }

}
