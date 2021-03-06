package ui.form;

import model.Book;

public class AddBookForm {

    private String isbn;
    private String title;
    private String authors;
    private double price;
    private int quantity;

    public AddBookForm(String isbn, String title, String authors, double price, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Book getBook() {
        return new Book(isbn, title, authors, price);
    }
}
