//TODO Make it so that no Null ever sets foot in here!
package ui;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import handling.Librarian;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author asty (original creator)
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.2
 */
public class ApplicationUI {

    // Name of the product in the menu (eg. product, book, magazine)
    // Set with "setProductType()"
    private String product = "item";

    // The class that will be communicating between the UI and the register.
    private Librarian librarian;

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
                "5. Add a series",
                "6. Add existing literature to a series",};

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        librarian = new Librarian();
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
                        showViewMenu();
                        break;

                    case 2:
                        showAddMenu();
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

    /**
     * Shows the "view" menu, where the user chooses what to look for.
     */
    private void showViewMenu() {
        int menuSelection;
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
                    
                default:
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR:"
                    + " Please provide a number between 1 and "
                    + this.viewMenuItems.length + "..\n");
        }

    }

    /**
     * Shows the "add" menu, where users can add literature to the register.
     */
    private void showAddMenu() {
        int menuSelection;
        try {
            // Display the "add" menu
            menuSelection = this.showMenu(addMenuItems);
            switch (menuSelection) {

                case 1: // Add a book
                    addNewProduct(1);
                    break;

                case 2: // Add a magazine
                    addNewProduct(2);
                    break;

                case 3:
                    addNewProduct(3);
                    break;

                case 4: // Add a newspaper
                    addNewProduct(4);
                    break;

                case 5:
                    // Add a series
                    break;

                case 6:
                    // Add existing literature to an existing series
                    break;
                    
                default:
                    break;

            }
        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR:"
                    + " Please provide a number between 1 and "
                    + this.addMenuItems.length + "..\n");
        }

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
    private void addNewProduct(int literatureTypeNr) {
        Scanner reader = new Scanner(System.in);
        boolean running = true;

        String title;
        String publisher;
        int year = 0;
        int month = 0;
        int day = 0;
        int releaseNr = 0;
        int isSeriesInt = 0;
        boolean isSeries = false;

        try {
            System.out.println("\nYou selected \"Add new " + product + ".\n\n");

            System.out.println("Enter name of literature: ");
            title = reader.nextLine();
            System.out.println("Enter name of publisher: ");
            publisher = reader.nextLine();
            System.out.println("Choose a literature type number:");
            System.out.println("1: Book");
            System.out.println("2: Magazine");
            System.out.println("3: Journal");
            literatureTypeNr = reader.nextInt();
            if (literatureTypeNr < 1) {
                literatureTypeNr = 1;
            } else if (literatureTypeNr > 3) {
                literatureTypeNr = 3;
            }
            while (isSeriesInt != 1 && isSeriesInt != 2) {
                System.out.println("Is the literature a series?");
                System.out.println("1: No");
                System.out.println("2: Yes");
                isSeriesInt = reader.nextInt();
            }
            if (isSeriesInt == 1) {
                isSeries = false;
            } else if (isSeriesInt == 2) {
                isSeries = true;
            }

            boolean dateIsValid = false;
            while (!dateIsValid) {
         try {
            System.out.println("Enter year of release (YYYY): ");
            year = reader.nextInt();
            System.out.println("Enter month of release (MM): ");
            month = reader.nextInt();
            System.out.println("Enter day of release (DD): ");
            day = reader.nextInt();

            librarian.addLiterature(title, publisher, year, month, day,
                    releaseNr, literatureTypeNr, isSeries);
            dateIsValid = true;
         } catch (DateTimeException dte) {
             dateIsValid = false;
             System.out.println( "\nERROR: " 
                     + year + "/" + month + "/" + day 
                     + " is not a valid date\n");
         }
            }

        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR: Expected an integer;");
        }
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
