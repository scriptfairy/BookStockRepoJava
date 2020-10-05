package model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class BookInventory {
    private Map<Book, Integer> quantityMap = new HashMap<>();
    private Map<String, Book> bookMap = new HashMap<>();

    public int getQuantity(Book book) {

        Integer quantity = this.quantityMap.get(book);
        if (quantity == null) {
            return 0;
        }
        return quantity.intValue();
    }

    public void setQuantity(Book book, int quantity) {
        this.quantityMap.put(book, Integer.valueOf(quantity));
    }

    public void addBook(Book book, int quantity) {
        this.bookMap.put(book.getIsbn(), book);
        setQuantity(book, quantity);
    }

    public ArrayList<Book> findAllBooksByTitle() {
        ArrayList<Book> books = new ArrayList<Book>(bookMap.values());
        books.sort(new BookTitleSorter());
        return books;
    }
}
