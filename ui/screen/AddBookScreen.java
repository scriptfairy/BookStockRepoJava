package ui.screen;

import java.util.ArrayList;
import java.util.Arrays;
import ui.form.TextInput;
import ui.form.TextInputDouble;
import ui.form.TextInputInteger;
import ui.form.AddBookForm;

public class AddBookScreen {

    public static AddBookForm showForm() {
        System.out.println("-----------------------------");
        System.out.println("Add Book");
        System.out.println("-----------------------------");

        String isbn = TextInput.prompt("Enter ISBN");
        String title = TextInput.prompt("Enter Title");
        String authors = TextInput.prompt("Enter author name(s) separated by comma if multiple");
        double price = TextInputDouble.prompt("Enter Price");
        int quantity = TextInputInteger.prompt("Enter Quantity");

        String[] authorsArr = authors.split(",");
        for (int i = 0; i < authorsArr.length; i++) {
            authorsArr[i] = authorsArr[i].trim();
        }

        AddBookForm form = new AddBookForm(isbn, title, new ArrayList<>(Arrays.asList(authorsArr)), price, quantity);
        return form;
    }
}
