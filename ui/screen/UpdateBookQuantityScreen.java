package ui.screen;

import ui.form.TextInput;

import model.Book;

public class UpdateBookQuantityScreen {
    public static String show(Book book, int quantity) {
        Common.showDivider();
        System.out.println("Update quantity for " + book.getTitle());
        Common.showDivider();
        System.out.println("Current quantity: " + quantity);
        return TextInput.prompt("Press [Enter] to leave unchanged");
    }

}
