package ui.form;

import util.io.Console;

public class TextInputInteger {

    public static int prompt(String message) {
        System.out.println(message);
        System.out.print(">> ");
        return Console.nextInt();
    }
}
