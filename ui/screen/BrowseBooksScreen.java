package ui.screen;

import model.BookBrowser;
import ui.menu.Menu;
import ui.menu.MenuItem;

public class BrowseBooksScreen {
    public static char COMMAND_RETURN = 'X';
    public static char COMMAND_NEXT = 'N';
    public static char COMMAND_UPDATE = 'U';
    public static char COMMAND_PREV = 'P';
    public static char COMMAND_DEL = 'D';

    private static void showNoBooksHeading() {
        Common.showHeading("No books found");
    }

    private static void showCurrentPageHeading(BookBrowser browser) {
        Common.showDivider();
        System.out.println("Showing book " + Integer.toString(browser.getCurrentPosition()) + " of "
                + Integer.toString(browser.getSize()));
        Common.showDivider();
    }

    private static MenuItem showMenu(BookBrowser browser) {
        Menu menu = new Menu();

        if (browser.hasNext()) {
            menu.add(new MenuItem(BrowseBooksScreen.COMMAND_NEXT, "Next"));
        }

        if (browser.hasPrev()) {
            menu.add(new MenuItem(BrowseBooksScreen.COMMAND_PREV, "Prev"));
        }

        if (browser.getSize() > 0) {
            menu.add(new MenuItem(BrowseBooksScreen.COMMAND_UPDATE, "Update"));
            menu.add(new MenuItem(BrowseBooksScreen.COMMAND_DEL, "Delete"));
        }

        menu.add(new MenuItem(BrowseBooksScreen.COMMAND_RETURN, "Return"));

        return menu.prompt();
    }

    public static MenuItem show(BookBrowser browser) {
        if (browser.getSize() == 0) {
            BrowseBooksScreen.showNoBooksHeading();
        } else {
            BrowseBooksScreen.showCurrentPageHeading(browser);
            Common.showBook(browser.getCurrentBook(), browser.getCurrentBookQuantity());
        }
        return BrowseBooksScreen.showMenu(browser);
    }

}
