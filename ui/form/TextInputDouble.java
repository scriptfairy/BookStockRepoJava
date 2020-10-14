package ui.form;

import java.util.InputMismatchException;
import util.io.Console;

public class TextInputDouble {
    public static double prompt(String message) {
        double value = 0;
        boolean isOk = false;
        do {
            System.out.println(message);
            System.out.print(">> ");
            try {
                value = Console.nextDouble();
                isOk = true;
            } catch (InputMismatchException e) {
                Console.nextLine(); // Clear the invalid characters
                isOk = false;
            }
        } while (!isOk);
        return value;
    }
}
