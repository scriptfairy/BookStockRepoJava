package model;

/**
 * This is just a data transfer object this is why all vars are public It is a
 * memory represntation of the each record in the file This class is used for
 * when saving and loading books from a file Each BookRecord represent one book
 * BookStorage is going to make use of this class
 */
public class BookRecord {

    private String isbn;
    private String title;
    private String authors;
    private double price;
    private int quantity;

    public BookRecord(String isbn, String title, String authors, double price, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthors() {
        return this.authors;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

}
