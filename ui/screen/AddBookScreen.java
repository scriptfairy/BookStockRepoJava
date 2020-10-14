package ui.screen;

import ui.form.TextInput;
import ui.form.TextInputDouble;
import ui.form.TextInputInteger;
import ui.form.AddBookForm;

public class AddBookScreen {

    public static AddBookForm showForm() {
        Common.showHeading("Add Book");

        String isbn = TextInput.prompt("Enter ISBN");
        String title = TextInput.prompt("Enter Title");
        String authors = TextInput.prompt("Enter author name(s) separated by comma if multiple");
        double price = TextInputDouble.prompt("Enter Price");
        int quantity = TextInputInteger.prompt("Enter Quantity");

        AddBookForm form = new AddBookForm(isbn, title, authors, price, quantity);
        return form;
    }
}
