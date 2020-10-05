package ui.screen;

import ui.form.TextInput;

import model.Book;

public class UpdateBookPriceScreen {
    public static String show(Book book) {
        Common.showDivider();
        System.out.println("Update price for " + book.getTitle());
        Common.showDivider();
        System.out.println("Current price: " + book.getPrice());
        return TextInput.prompt("Press [Enter] to leave unchanged");
    }

}
