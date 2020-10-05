package ui.screen;

import ui.form.TextInput;

public class SearchBooksScreen {

    public static String show() {
        System.out.println("-----------------------------");
        System.out.println("Search Books");
        System.out.println("-----------------------------");

        return TextInput.prompt("Type Search Phrase");
    }
}
