package ui.menu;

public class MenuItem {

    private Character key;
    private String label;

    public MenuItem(Character key, String label) {
        this.key = key;
        this.label = label;
    }

    // getters

    public Character getKey() {
        return this.key;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString() {
        return "[ " + this.key + " ] " + this.label;
    }
}
