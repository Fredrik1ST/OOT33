package ui;

import ui.*;
import ui.show.*; // Static methods for displaying literature
import entries.*;
import handling.LiteratureRegister;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.DateTimeException;
import java.util.Set;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, such as displaying menus and
 * receiving input from the user.
 *
 * @author asty (original creator)
 * @author Hans Christian HF, Fredrik ST, Magnus RK
 * @version 0.2
 */
public class ApplicationUI {

    // The register storing all Literature and Series
    private LiteratureRegister litReg;

    // A Scanner that reads input from the user.
    private Parser parser;

    // Name of the product in the menu (eg. product, book, magazine)
    // Set with "setProductTypeName()".
    private String product = "item";

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
     * The "add" menu. Shows what the user can add to the register.
     */
    private String[] editMenuItems
            = {
                "1. Add a piece of literature",
                "2. Add a new series",
                "3. Add existing literature to a series",
                "4. Fill register for testing purposes",
                "5. Search for and remove literature",
                "6. Search for and remove series"};

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        litReg = new LiteratureRegister();
        parser = new Parser();
        ProductNumbers productTypes = new ProductNumbers();
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
                                "\nThank you for using Application v0.3. Bye!\n");
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
        int menuSelection = parser.nextInt();
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
                    System.out.println("WORK IN PROGRESS!");
                    break;

                case 4: // Fill register for testing
                    System.out.println("\nFilling register...");
                    fillRegister();
                    System.out.println("Register filled.");
                    break;

                case 5: // Remove single literature
                    removeProductBySearch();
                    break;

                case 6: // Remove a series
                    System.out.println("WORK IN PROGRESS!");
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
        listIndexedEntries(litReg.getAllLiterature());
    }

    /**
     * Lists all series in the register.
     */
    private void listSeries() {
        ArrayList<Entry> litList = litReg.getAllLiterature();
        ArrayList<Entry> seriesList = new ArrayList<Entry>();
        for (Entry e : litList) {
            if (e instanceof Series) {
                Series s = (Series) e;
                seriesList.add(s);
            }
        }
        listIndexedEntries(seriesList);
    }

    /**
     * Lists all literature containing the search string in their title.
     */
    private void listByTitle() {
        String searchString;
        System.out.println("\nYou selected \"Find literature by title\"");
        System.out.println("Enter title to search for: ");
        searchString = parser.nextLine();

        ArrayList<Entry> litList = litReg.getByTitle(searchString);
        listIndexedEntries(litList);

    }

    /**
     * Lists all literature containing the search string in their title.
     */
    private void listByPublisher() {
        String searchString;
        System.out.println("\nYou selected \"Find literature by publisher\"");
        System.out.println("Enter publisher to search for: ");
        searchString = parser.nextLine();

        ArrayList<Entry> litList = litReg.getByPublisher(searchString);
        listIndexedEntries(litList);
    }

    /**
     * Add a new piece of literature to the literature register.
     */
    private void addNewProduct() {
        boolean wasAdded = false;
        boolean isSeries = false;
        int answer = 0;

        String title;
        String publisher;
        String genre;
        String author = "default";
        int year = 0;
        int month = 0;
        int day = 0;
        int releaseNr = 0;
        int edition = 1;
        int productTypeNumber = 0;

        System.out.println(
                "\nYou selected \"Add a piece of literature\".\n");

        while (productTypeNumber < 1
                || productTypeNumber > (ProductNumbers.getListLength())) {
            System.out.println("Choose a literature type:");
            System.out.println(ProductNumbers.displayTypes());
            productTypeNumber = parser.nextInt();
        }

        System.out.println("Enter title of literature: ");
        title = parser.nextLine();
        System.out.println("Enter name of publisher: ");
        publisher = parser.nextLine();
        System.out.println("Enter genre: ");
        genre = parser.nextLine();
        if (ProductNumbers.getProductTypes()[productTypeNumber].equals("book")) {
            System.out.println("Enter name of author: ");
            author = parser.nextLine();
            System.out.println("Enter edition number: ");
            edition = parser.nextInt();
        }

        System.out.println("Does the "
                + ProductNumbers.getProductTypes()[productTypeNumber]
                + "have a release number? "
                + "\n 1. Yes"
                + "\n 2. No");
        while (answer < 1 || answer > 2) {
            answer = parser.nextInt();
        }
        if (answer == 1) {
            while (releaseNr <= 0) {
                System.out.println("Enter release number:");
                releaseNr = parser.nextInt();
            }
        }

        boolean dateIsValid = false;

        while (!dateIsValid) {
            try {
                System.out.println("Enter year of release (YYYY): ");
                year = parser.nextInt();
                System.out.println("Enter month of release (MM): ");
                month = parser.nextInt();
                System.out.println("Enter day of release (DD): ");
                day = parser.nextInt();

                switch (ProductNumbers.getProductTypes()[productTypeNumber]) {

                    case "book": //Book
                        wasAdded = litReg.addLiterature(
                                new Book(title, publisher, genre,
                                        year, month, day, releaseNr, author, edition));
                        break;

                    case "magazine": //Magazine
                        wasAdded = litReg.addLiterature(
                                new Magazine(title, publisher, genre,
                                        year, month, day, releaseNr));

                        break;

                    case "journal": //Journal
                        wasAdded = litReg.addLiterature(
                                new Journal(title, publisher, genre,
                                        year, month, day, releaseNr));
                        break;

                    case "newspaper": //Newspaper
                        wasAdded = litReg.addLiterature(
                                new Newspaper(title, publisher, genre,
                                        year, month, day, releaseNr));
                        break;

                    default:
                        break;

                }
                dateIsValid = true;
            } catch (DateTimeException dte) {
                dateIsValid = false;
                System.out.println("\nERROR: "
                        + year + "/" + month + "/" + day
                        + " is not a valid date\n");
            }
        }

        if (!wasAdded) {
            System.out.println("The "
                    + ProductNumbers.getProductTypes()[productTypeNumber]
                    + " could not be added.\n");
        }

    }

    /**
     * Removes a piece of literature from the literature register.
     */
    private void removeProductBySearch() {
        boolean wasRemoved = false;
        String searchString = "";

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

        System.out.println("Search for entries to remove: ");
        searchString = parser.nextLine();
        ArrayList<Entry> matches = litReg.getByTitle(searchString);

        // Creates an indexed list of the matching Entries.
        listIndexedEntries(matches);

        // Chooses an indexed Entry and deletes it from litReg.
        wasRemoved = litReg.removeLiterature(chooseIndexedEntry(matches));

        if (!wasRemoved) {
            System.out.println("\nThe "
                    + ProductNumbers.getProductTypes()[productTypeNumber]
                    + " could not be removed.");
        }
    }

    /**
     * Adds a new literature series.
     */
    private void addNewSeries() {
        boolean wasAdded = false;
        String title = "";
        int releasesPerYear = 0;
        int productTypeNumber = 0;
        String publisher = "";
        String genre = "";

        System.out.println("\nYou selected \"Add new series\".\n\n");

        while (productTypeNumber < 1
                || productTypeNumber > (ProductNumbers.getListLength())) {
            System.out.println("Choose a literature type:");
            System.out.println(ProductNumbers.displayTypes());
            productTypeNumber = parser.nextInt();
        }

        System.out.println("Enter name of series: ");
        title = parser.nextLine();

        System.out.println("Enter publisher: ");
        publisher = parser.nextLine();

        System.out.println("Enter genre: ");
        genre = parser.nextLine();

        System.out.println("Enter releases per year (or 0 if unknown): ");
        releasesPerYear = parser.nextInt();

        switch (ProductNumbers.getProductTypes()[productTypeNumber]) {

            case "book": //Book
                wasAdded = litReg.addLiterature(
                        new BookSeries(title, publisher,
                                genre, releasesPerYear));
                break;

            case "magazine": //Magazine
                wasAdded = litReg.addLiterature(
                        new MagazineSeries(title, publisher,
                                genre, releasesPerYear));

                break;

            case "journal": //Journal
                wasAdded = litReg.addLiterature(
                        new JournalSeries(title, publisher,
                                genre, releasesPerYear));
                break;

            case "newspaper": //Newspaper
                wasAdded = litReg.addLiterature(
                        new NewspaperSeries(title, publisher, genre,
                                releasesPerYear));
                break;

            default:
                break;
        }
        if (!wasAdded) {
            System.out.println("The "
                    + ProductNumbers.getProductTypes()[productTypeNumber]
                    + " series could not be added. An identical entry exists.");
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

    /**
     * Fills up the register with various literature. For testing.
     */
    public void fillRegister() {
        litReg.addLiterature(new Book(
                "A book", "some publisher", "a genre", 1995, 11, 18, 0, "author", 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 1));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 2));
        litReg.addLiterature(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 3));
        Series series = new MagazineSeries(
                "A magazine series", "some publisher", "a genre", 3);
        series.add(new Magazine(
                "A magazine", "some publisher", "a genre", 1995, 11, 18, 1));
        litReg.addLiterature(series);
    }

    /**
     * Prints details of given Literature
     */
    public void printDetails(Entry l) {
        if (l instanceof Series) {
            Series s = (Series) l;
            System.out.print(ShowSeries.getDetailsAsString(s));
        } else if (l instanceof Book) {
            Book b = (Book) l;
            System.out.print(ShowBook.getDetailsAsString(b));
        } else if (l instanceof Magazine) {
            Magazine m = (Magazine) l;
            System.out.print(ShowMagazine.getDetailsAsString(m));
        } else if (l instanceof Journal) {
            Journal j = (Journal) l;
            System.out.print(ShowJournal.getDetailsAsString(j));
        } else if (l instanceof Newspaper) {
            Newspaper np = (Newspaper) l;
            System.out.print(ShowNewspaper.getDetailsAsString(np));
        }
    }

    /**
     * Makes an indexed list of Entries out of the provided ArrayList.
     * The index starts at 1 instead of 0, which is what Java uses internally.
     * The "chooseIndexedEntry" enables the user to pick
     */
    public void listIndexedEntries(ArrayList<Entry> entries) {
        int index = 1;

        try {
            // Achtung! The printed list starts at 1 instead of 0!
            for (Entry e : entries) {
                System.out.print("\n\nEntry #" + (index) + ":");
                printDetails(e);
                index++;
            }

        } catch (NullPointerException npe) {
            System.out.print("ERROR: Nothing found!");
        }
    }

    /**
     * Returns an indexed Entry chosen by the user from an ArrayList.
     * To be used with the "listIndexedEntries" method above.
     *
     * @param entries The ArrayList the user picks an Entry from
     * @param choice The index (starting from 1) of the user's chosen Entry
     * @return the user's chosen Entry
     */
    public Entry chooseIndexedEntry(ArrayList<Entry> entries) {
        int index = 0;
        try {
            System.out.println("\n\nSelect an entry;\n");
            index = parser.nextInt();
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("\nERROR: non-existing index");
        }
        return entries.get(index - 1);
    }
}
