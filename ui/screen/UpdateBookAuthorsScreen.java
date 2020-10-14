package ui.screen;

import ui.form.TextInput;

import model.Book;

public class UpdateBookAuthorsScreen {
    public static String show(Book book) {
        Common.showDivider();
        System.out.println("Update authors for " + book.getTitle());
        Common.showDivider();
        System.out.println("Current Authors: " + book.getAuthors());
        return TextInput.prompt("Press [Enter] to leave unchanged");
    }

}
