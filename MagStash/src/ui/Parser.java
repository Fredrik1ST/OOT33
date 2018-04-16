package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A scanner with some useful methods for the UI.
 * Exists solely to reduce code duplication.
 *
 * @author Fredrik
 */
public class Parser {

    private Scanner parser;

    public Parser() {
    }

    /**
     * Simply employs the nextLine command from Scanner.
     *
     * @return the string entered by the user
     */
    public String nextLine() {
        parser = new Scanner(System.in);
        String input = "";
        input = parser.nextLine();
        return input;
    }

    /**
     * Simply employs the nextInt method from Scanner.
     *
     * @return the integer entered by the user
     */
    public int nextInt() {
        parser = new Scanner(System.in);
        int input = -1;
        try {
            while (input < 0) {
                input = parser.nextInt();
            }
        } catch (InputMismatchException ime) {
            System.out.println("\nPlease enter an integer\n");
            nextInt();
        }
        return input;
    }
}
