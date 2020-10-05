package ui.screen;

import ui.form.TextInput;

import model.Book;

public class UpdateBookTitleScreen {
    public static String show(Book book) {
        Common.showDivider();
        System.out.println("Update title for " + book.getTitle());
        Common.showDivider();
        System.out.println("Current title: " + book.getTitle());
        return TextInput.prompt("Press [Enter] to leave unchanged");
    }

}
