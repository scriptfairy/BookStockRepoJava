package ui.screen;

import ui.menu.Menu;
import ui.menu.MenuItem;

public class HomeScreen {
    private Menu menu;

    public static char COMMAND_X = 'X';
    public static char COMMAND_S = 'S';
    public static char COMMAND_B = 'B';
    public static char COMMAND_A = 'A';

    public HomeScreen() {
        menu = new Menu();
        menu.add(new MenuItem(HomeScreen.COMMAND_S, "Search"));
        menu.add(new MenuItem(HomeScreen.COMMAND_B, "Browse"));
        menu.add(new MenuItem(HomeScreen.COMMAND_A, "Add Book"));
        menu.add(new MenuItem(HomeScreen.COMMAND_X, "Exit"));
    }

    public MenuItem show() {
        showContent();
        return this.menu.prompt();
    }

    private void showContent() {
        System.out.println("--------------------------------");
        System.out.println("Book Stock System");
        System.out.println("--------------------------------");
    }

}
