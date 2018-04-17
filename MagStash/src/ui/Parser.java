package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.DateTimeException;

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
        boolean isInt = false;
        int input = -1;

        while (!isInt) {
            parser = new Scanner(System.in);

            try {
                while (input < 0) {
                    input = parser.nextInt();
                    if (input < 0) {
                        System.out.println("ERROR: Input must be positive");
                    }
                }
                isInt = true;

            } catch (InputMismatchException ime) {
                System.out.println("ERROR: Not an integer\n");
                parser.reset();
            }
        }
        return input;
    }
}
