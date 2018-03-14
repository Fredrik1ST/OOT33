package magstash.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import magstash.MagazineStand;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user.
 *
 * @author asty
 * @version 0.2
 */
public class ApplicationUI {

    public MagazineStand currentMagStand;

    // The menu that will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems
            = {
                "1. List all magazines",
                "2. Add new magazine",
                "3. Find a magazine by name",};

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
                        this.findProductByName();
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
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
     * Initializes the application. Typically you would create the
     * LiteratureRegistrer-instance here
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register (MagazineStand).
     */
    private void listAllProducts() {
        System.out.println("\nlistAllProducts() was called");
        System.out.println(currentMagStand.listAllMagazines() +"\n");
    }

    /**
     * Add a new magazine to the magazine stand.
     */
    private void addNewProduct() {
        
        Scanner reader = new Scanner(System.in);
        String newName = "";
        String newPublisher = "";
        int newReleaseNr;
        int newReleasesPerYear;
        int newYear;
        int newMonth;
        int newDay;

        System.out.println("\naddNewProduct() was called");

        while (newName.equals("")) {
            System.out.println("Enter name of series: ");
            newName = reader.nextLine();
        }
        while (newPublisher.equals("")) {
            System.out.println("Enter publisher: ");
            newPublisher = reader.nextLine();
        }
        
        try {
        System.out.println("Enter release number: ");
        newReleaseNr = reader.nextInt();
        System.out.println("Enter releases per year: ");
        newReleasesPerYear = reader.nextInt();
        System.out.println("Enter year of release (YYYY): ");
        newYear = reader.nextInt();
        System.out.println("Enter month of release (MM): ");
        newMonth = reader.nextInt();
        System.out.println("Enter day of release (DD): ");
        newDay = reader.nextInt();

        // Holy hairy moly. FALSE means it's a duplicate, and won't be added.
        if (!currentMagStand.addMagazine(newName, newPublisher, newReleaseNr, newReleasesPerYear, newYear, newMonth, newDay)) {
            System.out.println("Magazine already exists in the stand.");
        } //else {
          //  currentMagStand.addMagazine(newName, newPublisher, newReleaseNr, newReleasesPerYear, newYear, newMonth, newDay);
          //}
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR: Expected an integer. Returning to menu...");
        }

    }

    /**
     * Find and display a magazine based on its series' name and release number.
     */
    private void findProductByName() {
        try {
        Scanner reader = new Scanner(System.in);
        String seriesName = "";
        int magNumber;

        System.out.println("\nfindProductByName() was called");

        while (seriesName.equals("")) {
            System.out.println("Enter name of series: ");
            seriesName = reader.nextLine();
        }
        System.out.println("Enter release number: ");
        magNumber = reader.nextInt();

        if (currentMagStand.getMagazine(seriesName, magNumber) == null) {
            String answer = "";
            System.out.println("Could not find the magazine."
                        + " Do you want to list all magazines instead? (Y/N)");
            while (answer.equals("")) {
                answer = reader.nextLine();
            }
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                System.out.println(currentMagStand.listAllMagazines());
            }
            else {
                System.out.println("\nReturning to menu...");
            }
        } else {
            currentMagStand.getMagazine(seriesName, magNumber);
        }
        } catch (InputMismatchException ime) {
            System.out.println("\nERROR: Expected an integer. Returning to menu...");
        }
    }

}
