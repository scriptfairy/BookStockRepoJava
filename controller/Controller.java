package controller;

import ui.screen.*;

import ui.menu.MenuItem;

import ui.form.AddBookForm;

import model.BookStockModel;
import model.BookBrowser;
import model.Book;

public class Controller {
    private BookStockModel model;

    public Controller(BookStockModel model) {
        this.model = model;
    }

    private void showAddBookScreen() {
        AddBookForm form = AddBookScreen.showForm();
        model.addBook(form.getBook(), form.getQuantity());
        // TODO go to update book screen.
        showHome();
    }

    private void showSearchBooksScreen() {
        String query = SearchBooksScreen.show();
        this.model.browseBooksBySearchTerm(query);
        showBookBrowseScreen();
    }

    private void showBookBrowseScreen() {
        BookBrowser bookBrowser = this.model.getBookBrowser();
        MenuItem selected = BrowseBooksScreen.show(bookBrowser);

        if (selected.getKey() == BrowseBooksScreen.COMMAND_NEXT) {
            bookBrowser.next();
            showBookBrowseScreen();
            return;
        }
        if (selected.getKey() == BrowseBooksScreen.COMMAND_PREV) {
            bookBrowser.prev();
            showBookBrowseScreen();
            return;
        }
        if (selected.getKey() == BrowseBooksScreen.COMMAND_UPDATE) {
            showUpdateBookScreen();
            return;
        }

        if (selected.getKey() == BrowseBooksScreen.COMMAND_RETURN) {
            showHome();
            return;
        }
    }

    private void showUpdateBookScreen() {
        BookBrowser bookBrowser = this.model.getBookBrowser();
        MenuItem selected = UpdateBookScreen.show(bookBrowser);

        if (selected.getKey() == UpdateBookScreen.COMMAND_I) {
            this.showUpdateBookIsbnScreen();
            return;
        }

        if (selected.getKey() == UpdateBookScreen.COMMAND_A) {
            this.showUpdateBookAuthorsScreen();
            return;
        }

        if (selected.getKey() == UpdateBookScreen.COMMAND_T) {
            this.showUpdateBookTitleScreen();
            return;
        }

        if (selected.getKey() == UpdateBookScreen.COMMAND_Q) {
            this.showUpdateBookQuantityScreen();
            return;
        }

        if (selected.getKey() == UpdateBookScreen.COMMAND_P) {
            this.showUpdateBookPriceScreen();
            return;
        }

    }

    private void showUpdateBookPriceScreen() {
        Book book = this.model.getBookBrowser().getCurrentBook();
        String newPrice = UpdateBookPriceScreen.show(book);
        try {
            double price = Double.parseDouble(newPrice);
        } catch (NumberFormatException ex) {
            Common.showLine("ERROR: Invalid price");
            showUpdateBookPriceScreen();
        }

    }

    private void showUpdateBookQuantityScreen() {
        Book book = this.model.getBookBrowser().getCurrentBook();
        int quantity = this.model.getBookBrowser().getCurrentBookQuantity();
        String newQuantity = UpdateBookQuantityScreen.show(book, quantity);
        try {
            quantity = Integer.parseInt(newQuantity);
        } catch (NumberFormatException ex) {

            Common.showLine("ERROR: Invalid quantity");
            showUpdateBookQuantityScreen();
        }
        this.model.setQuantity(book, quantity);
        this.showUpdateBookScreen();
    }

    private void showUpdateBookTitleScreen() {
        Book book = this.model.getBookBrowser().getCurrentBook();
        String title = UpdateBookTitleScreen.show(book);
        if (title.length() > 0) {
            book.setTitle(title);
        }
        this.showUpdateBookScreen();
    }

    private void showUpdateBookIsbnScreen() {
        Book book = this.model.getBookBrowser().getCurrentBook();
        String isbn = UpdateBookIsbnScreen.show(book);
        if (isbn.length() > 0) {
            book.setIsbn(isbn);
        }
        this.showUpdateBookScreen();
    }

    private void showUpdateBookAuthorsScreen() {
        Book book = this.model.getBookBrowser().getCurrentBook();
        String authors = UpdateBookAuthorsScreen.show(book);
        if (authors.length() > 0) {
            book.setAuthors(authors);
        }
        this.showUpdateBookScreen();
    }

    private void showHome() {
        HomeScreen homeScreen = new HomeScreen();
        MenuItem selected = homeScreen.show();

        if (selected.getKey() == HomeScreen.COMMAND_X) {
            return;
        }

        if (selected.getKey() == HomeScreen.COMMAND_A) {
            showAddBookScreen();
            return;
        }

        if (selected.getKey() == HomeScreen.COMMAND_B) {
            this.model.browseAllBooksByTitle();
            showBookBrowseScreen();
            return;
        }

        if (selected.getKey() == HomeScreen.COMMAND_S) {
            showSearchBooksScreen();
            return;
        }

    }

    public void start() {
        this.showHome();
    }

}
