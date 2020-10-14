package ui.form;

import java.util.InputMismatchException;
import util.io.Console;

public class TextInputInteger {

    public static int prompt(String message) {
        int value = 0;
        boolean isOk = false;
        do {
            System.out.println(message);
            System.out.print(">> ");
            try {
                value = Console.nextInt();
                isOk = true;
            } catch (InputMismatchException e) {
                Console.nextLine(); // Clear the invalid characters
                isOk = false;
            }
        } while (!isOk);
        return value;
    }
}
