package model;

/**
 * Book represents a book object in real life. it has isbn, title, author(s) and
 * price
 * 
 */
public class Book {

    private String isbn;
    private String title;
    private String authors;
    private double price;

    public Book(String isbn, String title, String authors, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authors = authors;

    }

    // Getters
    public String getIsbn() {
        return this.isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public String getAuthors() {
        return this.authors;
    }

    // Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * hashCode is used internally by HashMap set If two objects are equal according
     * to the equals() method, then calling the hashCode method on each of the two
     * objects must produce the same integer result.
     */
    public int hashCode() {
        return this.isbn.hashCode();
    }

    /**
     * Each book has unique ISBN
     */
    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return book.isbn == this.isbn;
        }
        return false;
    }
}
