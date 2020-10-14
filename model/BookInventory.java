package model;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Singleton to store books and their quantity Inventory is loaded initially
 * from books.txt Inventory is updated when adding new book or updating existing
 * book. Inventory responsible of updating books.txt file Only model talks to
 * inventory
 */
public class BookInventory {
    private Map<Book, Integer> quantityMap = new HashMap<>();
    private Map<String, Book> bookMap = new HashMap<>();
    private BookStorage bookStorage;

    public BookInventory(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
        ArrayList<BookRecord> records = bookStorage.loadBooks();
        Iterator<BookRecord> iter = records.iterator();
        BookRecord record;
        Book book;
        while (iter.hasNext()) {
            record = (BookRecord) iter.next();
            book = new Book(record.getIsbn(), record.getTitle(), record.getAuthors(), record.getPrice());
            this.addBook(book, record.getQuantity());
        }

    }

    public void saveInventory() {
        ArrayList<Book> books = new ArrayList<Book>(bookMap.values());
        ArrayList<BookRecord> bookRecords = new ArrayList<BookRecord>();
        int len = books.size();
        for (int i = 0; i < len; i++) {
            Book book = books.get(i);
            String authors = book.getAuthors();
            authors = authors.replace(",", "|");
            int quantity = this.getQuantity(book);
            BookRecord bookRecord = new BookRecord(book.getIsbn(), book.getTitle(), authors, book.getPrice(), quantity);
            bookRecords.add(bookRecord);
        }
        this.bookStorage.saveBooks(bookRecords);
    }

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

    public void deleteBook(Book book) {
        this.bookMap.remove(book.getIsbn());
        this.quantityMap.remove(book);
    }

    public ArrayList<Book> findAllBooksByTitle() {
        ArrayList<Book> books = new ArrayList<Book>(bookMap.values());
        books.sort(new BookTitleSorter());
        return books;
    }
}
