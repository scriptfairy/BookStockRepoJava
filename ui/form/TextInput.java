package ui.form;

import util.io.Console;

public class TextInput {
    public static String prompt(String message) {
        System.out.println(message);
        System.out.print(">> ");
        return Console.nextLine();
    }
}
