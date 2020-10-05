package ui.form;

import util.io.Console;

public class TextInputDouble {
    public static double prompt(String message) {
        System.out.println(message);
        System.out.print(">> ");
        return Console.nextDouble();
    }
}
