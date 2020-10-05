package ui.screen;

import ui.menu.Menu;
import ui.menu.MenuItem;

import model.BookBrowser;
import model.Book;

public class UpdateBookScreen {
    public static char COMMAND_X = 'X';
    public static char COMMAND_I = 'I';
    public static char COMMAND_T = 'T';
    public static char COMMAND_A = 'A';
    public static char COMMAND_Q = 'Q';
    public static char COMMAND_P = 'P';
    public static char COMMAND_B = 'B';

    private static MenuItem showMenu(BookBrowser browser) {
        Menu menu = new Menu();
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_I, "Update ISBN"));
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_T, "Update Title"));
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_A, "Update Author(s)"));
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_Q, "Update Quantity"));
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_P, "Update Price"));
        menu.add(new MenuItem(UpdateBookScreen.COMMAND_X, "Back"));
        return menu.prompt();
    }

    public static MenuItem show(BookBrowser browser) {
        Book book = browser.getCurrentBook();
        int quantity = browser.getCurrentBookQuantity();
        Common.showHeading("Update " + book.getTitle());
        Common.showBook(book, quantity);
        return UpdateBookScreen.showMenu(browser);
    }

}
