package ui.screen;

import model.Book;

public class Common {
    public static void showLine(String message) {
        System.out.println(message);
    }

    public static void showDivider() {
        Common.showLine("-----------------------------");
    }

    public static void showGap() {
        Common.showLine("");
    }

    public static void showHeading(String message) {
        Common.showDivider();
        Common.showLine(message);
        Common.showDivider();
    }

    public static void showBook(Book book, int quantity) {
        Common.showLine("ISBN: " + book.getIsbn());
        Common.showLine("Title: " + book.getTitle());
        Common.showLine("Quantity: " + Integer.toString(quantity));
        Common.showLine("Author(s): " + book.getAuthorsAsString());
        Common.showLine("Price: " + Double.toString(book.getPrice()));
        Common.showGap();
    }

}
