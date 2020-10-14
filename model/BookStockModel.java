package model;

import java.util.ArrayList;

public class BookStockModel {
    private BookInventory inventory;
    private BookBrowser bookBrowser;

    public void saveInventory() {
        this.inventory.saveInventory();
    }

    public BookStockModel(BookInventory inventory) {
        this.inventory = inventory;
    }

    public void addBook(Book book, int quantity) {
        this.inventory.addBook(book, quantity);
        this.inventory.saveInventory();
    }

    public void deleteBook(Book book) {
        this.inventory.deleteBook(book);
        this.inventory.saveInventory();
    }

    public void setQuantity(Book book, int quantity) {
        this.inventory.setQuantity(book, Integer.valueOf(quantity));
        this.inventory.saveInventory();
    }

    public void browseAllBooksByTitle() {
        ArrayList<Book> books = inventory.findAllBooksByTitle();
        this.bookBrowser = new BookBrowser(inventory, books);
    }

    public void browseBooksBySearchTerm(String query) {
        query = query.toLowerCase();

        ArrayList<Book> result = new ArrayList<Book>();

        ArrayList<Book> books = inventory.findAllBooksByTitle();

        int len = books.size();
        String authors = "";
        for (int i = 0; i < len; i++) {
            authors = books.get(i).getAuthors();
            if (books.get(i).getTitle().toLowerCase().contains(query) || authors.toLowerCase().contains(query)) {
                result.add(books.get(i));
                continue;
            }
        } // End for
        this.bookBrowser = new BookBrowser(inventory, result);
    }

    public BookBrowser getBookBrowser() {
        return this.bookBrowser;
    }

}
