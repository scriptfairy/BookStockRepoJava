package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class Book {

    private String isbn;
    private String title;
    private ArrayList<String> authors;
    private double price;

    public Book(String isbn, String title, ArrayList<String> authors, double price) {
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

    public ArrayList<String> getAuthors() {
        return this.authors;
    }

    public String getAuthorsAsString() {
        Iterator<String> iter = getAuthors().iterator();
        String authorsStr = "";
        while (iter.hasNext()) {
            authorsStr = authorsStr + iter.next() + ", ";
        }
        authorsStr = authorsStr.trim();
        if (authorsStr != null && authorsStr.length() > 0 && authorsStr.charAt(authorsStr.length() - 1) == ',') {
            authorsStr = authorsStr.substring(0, authorsStr.length() - 1);
        }
        return authorsStr;
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

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public void setAuthors(String authors) {
        String[] authorsArr = authors.split(",");
        for (int i = 0; i < authorsArr.length; i++) {
            authorsArr[i] = authorsArr[i].trim();
        }
        this.authors = new ArrayList<String>(Arrays.asList(authorsArr));
    }

    public int hashCode() {
        return this.isbn.hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof Book) {
            Book book = (Book) o;
            return book.isbn == this.isbn;
        }
        return false;
    }
}
