//TODO Make it so that no Null ever sets foot in here!
package ui;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import handling.Librarian;
import handling.ProductTypeNumbers;

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
    // Set with "setProductTypeName()".
    private String product = "item";

    // The class that will be communicating between the UI and the register.
    private Librarian librarian;

    // A list of all existing literature types with corresponding index numbers.
    private ProductTypeNumbers typeList;

    /**
     * The start menu (Top layer).
     */
    private String[] startMenuItems
            = {
                "1. View & search for " + product + "s...",
                "2. Add or remove " + product + "s...",};

    /**
     * The "view" menu. Shows what the user can choose to view.
     */
    private String[] viewMenuItems
            = {
                "1. List all literature",
                "2. Find literature by title",
                "3. Find literature by publisher",};

    /**
     * The "add" menu. Shows what the user can add to the regiter.
     */
    private String[] editMenuItems
            = {
                "1. Add a piece of literature",
                "2. Add a new series",
                "3. Add existing literature to a series",
                "4. Fill register for testing purposes",
                "4. Remove literature",
                "5. Remove series"};

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        librarian = new Librarian();
        typeList = new ProductTypeNumbers();
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
                        showEditMenu();
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
                        + (this.startMenuItems.length + 1) + "..\n");
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
        System.out.println(
                "Please choose menu item (1-" + maxMenuItemNumber + "): ");
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

                case 1: // List all literature
                    listAllProducts();
                    break;

                case 2: // Find by title
                    listByTitle();
                    break;

                case 3: // Find by publisher
                    listByPublisher();
                    break;

                default:
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR:"
                    + " Please provide a number between 1 and "
                    + (this.viewMenuItems.length + 1) + "..\n");
        }

    }

    /**
     * Shows the "edit" menu, where users can add/remove literature.
     */
    private void showEditMenu() {
        int menuSelection;
        try {
            // Display the "add" menu
            menuSelection = this.showMenu(editMenuItems);
            switch (menuSelection) {

                case 1: // Add a standalone piece of literature
                    addNewProduct();
                    break;

                case 2: // Add a series
                    addNewSeries();
                    break;

                case 3: // Add existing literature to an existing series

                    break;

                case 4: // Fill register for testing
                    System.out.println("\nFilling register...");
                    librarian.fillRegister();
                    break;

                case 5: // Remove single literature
                    removeProduct();
                    break;
                default:
                    break;

            }
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR:"
                    + " Please provide a number between 1 and "
                    + (this.editMenuItems.length + 1) + "..\n");
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
     * Lists all literature in the register.
     */
    private void listAllProducts() {
        System.out.println("\nYou selected \"List all literature\"");
        System.out.println(librarian.getDetails(librarian.getRegister()));
    }

    /**
     * Lists all literature containing the search string in their title.
     */
    private void listByTitle() {
        String searchString;
        Scanner reader = new Scanner(System.in);
        System.out.println("\nYou selected \"Find literature by title\"");
        System.out.println("Enter title to search for: ");
        searchString = reader.nextLine();

        System.out.println(librarian.getDetailsByTitle(
                librarian.getRegister(), searchString));
    }

    /**
     * Lists all literature containing the search string in their title.
     */
    private void listByPublisher() {
        String searchString;
        Scanner reader = new Scanner(System.in);
        System.out.println("\nYou selected \"Find literature by publisher\"");
        System.out.println("Enter publisher to search for: ");
        searchString = reader.nextLine();

        System.out.println(librarian.getDetailsByPublisher(
                librarian.getRegister(), searchString));
    }

    /**
     * Add a new piece of literature to the literature register.
     */
    private void addNewProduct() {
        Scanner reader = new Scanner(System.in);
        boolean running = true;

        String title;
        String publisher;
        String genre;
        String author = "default";
        int year = 0;
        int month = 0;
        int day = 0;
        int releaseNr = 0;
        int edition = 1;
        int isSeriesInt = 0;
        int productTypeNumber = 0;
        boolean isSeries = false;

        try {
            System.out.println(
            "\nYou selected \"Add a piece of literature\".\n\n");

            while (productTypeNumber < 1
                    || productTypeNumber > (typeList.getListLength())) {
                System.out.println("Choose a literature type:");
                System.out.println(typeList.displayTypes());
                productTypeNumber = reader.nextInt();
                reader.nextLine();
            }

            System.out.println("Enter title of literature: ");
            title = reader.nextLine();
            System.out.println("Enter name of publisher: ");
            publisher = reader.nextLine();
            System.out.println("Enter genre: ");
            genre = reader.nextLine();
            if (typeList.getProductTypes()[productTypeNumber].equals("book")) {
                System.out.println("Enter name of author: ");
                author = reader.nextLine();
                System.out.println("Enter edition number: ");
                edition = reader.nextInt();
                reader.nextLine();

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

                    if (librarian.addLiterature(title, publisher, genre,
                            year, month, day,
                            releaseNr, productTypeNumber, author, edition)) {
                        System.out.println(title + "was added");
                    } else {
                        System.out.println("ERROR: " + title
                                + " already exists");
                    }
                    dateIsValid = true;
                } catch (DateTimeException dte) {
                    dateIsValid = false;
                    System.out.println("\nERROR: "
                            + year + "/" + month + "/" + day
                            + " is not a valid date\n");
                }
            }

        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR: Expected an integer \nPlease try again");
        }
    }

    /**
     * Removes a piece of literature from the literature register.
     */
    private void removeProduct() {
        Scanner reader = new Scanner(System.in);
        boolean running = true;

        String title;
        String publisher;
        String genre;
        String author = "default";
        int year = 0;
        int month = 0;
        int day = 0;
        int releaseNr = 0;
        int edition = 1;
        int isSeriesInt = 0;
        int productTypeNumber = 0;
        boolean isSeries = false;

        try {
            System.out.println(
                    "\nYou selected \"Remove literature\".\n\n");

            while (productTypeNumber < 1
                    || productTypeNumber > (typeList.getListLength())) {
                System.out.println("Choose a literature type:");
                System.out.println(typeList.displayTypes());
                productTypeNumber = reader.nextInt();
                reader.nextLine();
            }

            System.out.println("Enter title of literature: ");
            title = reader.nextLine();
            System.out.println("Enter name of publisher: ");
            publisher = reader.nextLine();
            System.out.println("Enter genre: ");
            genre = reader.nextLine();
            if (typeList.getProductTypes()[productTypeNumber].equals("book")) {
                System.out.println("Enter name of author: ");
                author = reader.nextLine();
                System.out.println("Enter edition number: ");
                edition = reader.nextInt();
                reader.nextLine();

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

                    if (librarian.removeLiterature(title, publisher, genre,
                            year, month, day,
                            releaseNr, productTypeNumber, author, edition)) {
                        System.out.println(title + "was removed");
                    } else {
                        System.out.println("ERROR: " + title
                                + " does not exist,"
                                + "or parameters may be wrong");
                    }
                    dateIsValid = true;
                } catch (DateTimeException dte) {
                    dateIsValid = false;
                    System.out.println("\nERROR: "
                            + year + "/" + month + "/" + day
                            + " is not a valid date\n");
                }
            }

        } catch (InputMismatchException ime) {
            System.out.println(
                    "\nERROR: Expected an integer \nPlease try again");
        }
    }

    /**
     * Adds a new literature series.
     */
    private void addNewSeries() {
        Scanner reader = new Scanner(System.in);
        String title = "";
        int releasesPerYear = 0;
        int productTypeNr = 0;
        String publisher = "";
        String genre = "";

        System.out.println("\nYou selected \"Add new series\".\n\n");

        while (productTypeNr < 1
                || productTypeNr > (typeList.getListLength())) {
            System.out.println("Choose a literature type:");
            System.out.println(typeList.displayTypes());
            productTypeNr = reader.nextInt();
            reader.nextLine();
        }

        System.out.println("Enter name of series: ");
        title = reader.nextLine();

        System.out.println("Enter publisher: ");
        publisher = reader.nextLine();

        System.out.println("Enter genre: ");
        genre = reader.nextLine();

        if (librarian.addSeries(title, publisher, genre,
                releasesPerYear, productTypeNr)) {
            System.out.println("Series " + title + " was added");
        } else {
            System.out.println("Series already exists");
        }

    }

    /**
     * Adds a new literature series.
     */
    private void removeSeries() {
        Scanner reader = new Scanner(System.in);
        String title = "";
        int releasesPerYear = 0;
        int productTypeNr = 0;
        String publisher = "";
        String genre = "";

        System.out.println("\nYou selected \"Remove series\".\n\n");

        while (productTypeNr < 1
                || productTypeNr > (typeList.getListLength())) {
            System.out.println("Choose a literature type:");
            System.out.println(typeList.displayTypes());
            productTypeNr = reader.nextInt();
            reader.nextLine();
        }

        System.out.println("Enter name of series: ");
        title = reader.nextLine();

        System.out.println("Enter publisher: ");
        publisher = reader.nextLine();

        System.out.println("Enter genre: ");
        genre = reader.nextLine();

        if (librarian.addSeries(title, publisher, genre,
                releasesPerYear, productTypeNr)) {
            System.out.println("Series " + title + " was removed");
        } else {
            System.out.println("ERROR: Series "
                    + title + " does not exist, or parameters may be wrong");
        }

    }

    /**
     * Name what type of product the UI is going to display.
     *
     * @param product the type of literature the UI will display (e.g. books)
     */
    public void setProductTypeName(String product) {
        this.product = product;
    }

}
