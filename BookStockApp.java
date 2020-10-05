import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;
import model.Book;
import model.BookInventory;
import model.BookStockModel;
import util.io.Console;

public class BookStockApp {
    public static void main(String[] args) {

        BookInventory inventory = new BookInventory();
        ArrayList<String> authors = new ArrayList<String>();

        authors.add("Neil Gaiman");
        authors.add("Terry Pratchett");
        Book b1 = new Book("0552137030", "Good Omens", authors, 10.30);
        Book b2 = new Book("1904233910", "Eclipse", new ArrayList<>(Arrays.asList("Stephenie Meyer")), 9.00);
        Book b3 = new Book("0450031063", "Salem's Lot", new ArrayList<>(Arrays.asList("Stephen King")), 13.00);
        Book b4 = new Book("0708860737", "Interview With the Vampire", new ArrayList<>(Arrays.asList("Anne Rice")),
                11.00);
        Book b5 = new Book("0735219346", "Dracul", new ArrayList<>(Arrays.asList("Dacre Stoker", "J. D. Barker")),
                7.00);
        Book b6 = new Book("978-0971977556", "30 Days Of Night", new ArrayList<>(Arrays.asList("Steve Niles")), 13.00);

        // Add books to inventory
        inventory.addBook(b1, 100);
        inventory.addBook(b2, 50);
        inventory.addBook(b3, 10);
        inventory.addBook(b4, 1000);
        inventory.addBook(b5, 250);
        inventory.addBook(b6, 5);

        Console.open();

        BookStockModel model = new BookStockModel(inventory);
        Controller controller = new Controller(model);

        controller.start();

        Console.close();

    }
}
