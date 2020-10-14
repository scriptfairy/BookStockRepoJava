package ui.screen;

import ui.menu.Menu;
import ui.menu.MenuItem;

import model.Book;

public class DeleteBookScreen {
    public static char COMMAND_DEL = 'D';
    public static char COMMAND_X = 'X';

    private static MenuItem showMenu(Book book) {
        Menu menu = new Menu();
        menu.add(new MenuItem(DeleteBookScreen.COMMAND_DEL, "Delete"));
        menu.add(new MenuItem(DeleteBookScreen.COMMAND_X, "Return Without Deleting the Book"));
        return menu.prompt();
    }

    public static MenuItem show(Book book) {
        Common.showHeading("Deleting " + book.getTitle());
        return DeleteBookScreen.showMenu(book);
    }

}
