package model;

import java.util.ArrayList;

public class BookBrowser {
    private ArrayList<Book> books;
    private BookInventory inventory;
    private int currentIndex = 0;

    public BookBrowser(BookInventory inventory, ArrayList<Book> books) {
        this.books = books;
        this.inventory = inventory;

    }

    public int getSize() {
        return books.size();
    }

    public int getCurrentPosition() {
        if (getSize() == 0) {
            return 0;
        }
        return currentIndex + 1;
    }

    public Book getCurrentBook() {
        Book book = books.get(currentIndex);
        return book;
    }

    public int getCurrentBookQuantity() {
        return inventory.getQuantity(getCurrentBook());
    }

    public boolean hasNext() {
        if (currentIndex < getSize() - 1) {
            return true;
        }
        return false;
    }

    public boolean hasPrev() {
        if (currentIndex > 0) {
            return true;
        }
        return false;
    }

    public void next() {
        if (hasNext()) {
            this.currentIndex = this.currentIndex + 1;
        }
    }

    public void prev() {
        if (hasPrev()) {
            this.currentIndex = this.currentIndex - 1;
        }

    }
}
