import java.util.ArrayList;
/**
 * This is just a data transfer object this is why all vars are public
 * It is a memory represntation of the each record in the file
 * This class is used for when saving and loading books from a file
 * Each BookRecord represent one book
 * BookStorage is going to make use of this class
 */
public class BookRecord {

    public String isbn;

    public BookRecord(String isbn, String title, ArrayList<String> authors,double price, int quantity){
        this.isbn = isbn;
        // rest the same.....
    }
    
}
