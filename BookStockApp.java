import controller.Controller;
import model.*;
import util.io.Console;
import java.io.File;

/**
 * Main App class, it starts Book Stock Application. main() uploads the
 * inventory from a text file called books.txt Initiate the model. Initiate the
 * controller
 */
public class BookStockApp {
    public static void main(String[] args) {
        File file = new File("books.txt");
        String path = file.getAbsolutePath();
        BookStorage bookStorage = new BookStorage(path);

        BookInventory inventory = new BookInventory(bookStorage);

        Console.open();

        BookStockModel model = new BookStockModel(inventory);
        Controller controller = new Controller(model);

        controller.start();

        Console.close();

    }
}
