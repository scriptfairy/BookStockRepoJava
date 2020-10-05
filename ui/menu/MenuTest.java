package ui.menu;

public class MenuTest {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.add(new MenuItem('S', "Search"));
        menu.add(new MenuItem('B', "Browse"));
        menu.add(new MenuItem('A', "Add Book"));
        menu.add(new MenuItem('X', "Exit"));

        // MenuItem selected = menu.prompt();
        // System.out.println("You selected " + selected.getKey());

        MenuItem item = menu.prompt();
        System.out.println(item);
    }
}
