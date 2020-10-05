import java.util.ArrayList;
import java.io.FileNotFoundException;

public class BookStorageTest{
    public static void main(String[] args) throws FileNotFoundException {
        /* */
        BookStorage.createBookFile();

        /* books : Twilight Saga */
        ArrayList<String> authors_Twilight = new ArrayList<>();
        authors_Twilight.add("Stephanie Meyer");
        BookRecord book_Twilight = new BookRecord("ISBN_Twilight","Twilight",authors_Twilight,20.00,100);

        ArrayList<String> authors_NewMoon = new ArrayList<>();
        authors_NewMoon.add("Stephanie Meyer");
        authors_NewMoon.add("Stephanie Meyer1");
        BookRecord book_NewMoon = new BookRecord("ISBN_NewMoon","New Moon",authors_NewMoon,20.00,100);

        ArrayList<String> authors_Eclipse = new ArrayList<>();
        authors_Eclipse.add("Stephanie Meyer");
        BookRecord book_Eclipse = new BookRecord("ISBN_Eclipse","Eclipse",authors_Eclipse,20.00,100);

        ArrayList<String> authors_BreakingDown = new ArrayList<>();
        authors_BreakingDown.add("Stephanie Meyer");
        BookRecord book_BreakingDown = new BookRecord("ISBN_BreakingDown","Breaking Down",authors_BreakingDown,20.00,100);

        ArrayList<String> authors_BreakingDown1 = new ArrayList<>();
        authors_BreakingDown1.add("Stephanie Meyer");
        BookRecord book_BreakingDown1 = new BookRecord("ISBN_BreakingDown","Breaking Down",authors_BreakingDown,20.00,100);

        ArrayList<BookRecord> books = new ArrayList<>();
        books.add(book_Twilight);
        books.add(book_NewMoon);
        books.add(book_Eclipse);
        books.add(book_BreakingDown);
        books.add(book_BreakingDown1);
        BookStorage.saveBooks(books);

        BookStorage.loadBooks("/Users/Vikask/Desktop/Java_Atom/Vikas/books.txt");

        // TODO by Vikas
        // 1) Add another book with 2 authors
        // 2) Add the book in book array
        // 3) Save books in books.txt
        // 4) Complete loadBooks function to load the saved data.

    }


}
