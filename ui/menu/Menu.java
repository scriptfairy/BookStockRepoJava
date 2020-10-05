package ui.menu;

import java.util.*;
import util.io.Console;

public class Menu {
    private ArrayList<MenuItem> menuItems = new ArrayList<>();

    public void add(MenuItem item) {
        this.menuItems.add(item);
    }

    public void add(Character key, String label) {
        this.add(new MenuItem(key, label));
    }

    /**
     * The function is responsible for displaying the menu items, and return
     * selected one
     * 
     * @return MenuItem selected
     */
    public MenuItem prompt() {
        // Display menu items on the screen
        Iterator<MenuItem> iter = menuItems.iterator();
        MenuItem item;

        while (iter.hasNext()) {
            item = (MenuItem) iter.next();
            Character c = item.getKey();
            String s = item.getLabel();

            // Print to the screen each menu
            System.out.println("[ " + c + " ] " + s);
        }

        do {
            // Prompt the user to select one option
            System.out.println();
            System.out.print("Select an option >> ");
            String st = Console.nextLine();

            // Check st has length
            while (st.length() == 0) {
                st = Console.nextLine();
            }
            char input = st.charAt(0);
            item = findSelectedItem(input);
        } while (item == null);

        return item;
    }

    private MenuItem findSelectedItem(char input) {
        Iterator<MenuItem> iter = menuItems.iterator();

        while (iter.hasNext()) {
            MenuItem item = (MenuItem) iter.next();
            if (Character.toLowerCase(item.getKey()) == Character.toLowerCase(input)) {
                return item;
            }
        }
        return null;
    }
}
