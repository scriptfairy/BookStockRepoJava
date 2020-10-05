package ui.screen;

import ui.form.TextInput;

import model.Book;

public class UpdateBookIsbnScreen {
    public static String show(Book book) {
        Common.showDivider();
        System.out.println("Update ISBN for " + book.getTitle());
        Common.showDivider();
        System.out.println("Current ISBN: " + book.getIsbn());
        return TextInput.prompt("Press [Enter] to leave unchanged");
    }

}
