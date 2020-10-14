package model;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * BookStorage is responsible for saving and loading books from a file.
 *
 * The book data will stored in a file named books.txt
 *
 * books.txt file will have the following format:
 *
 * ISBN,Book Title,Author 1|Author 2|Author 3,Price,Quantity
 *
 *
 */
public class BookStorage {

  private String fileName;

  /**
   * Input is ArrayList of BookRecord The method will overwrite the data in the
   * books.txt with the the records in books
   */
  public BookStorage(String fileName) {
    this.fileName = fileName;
  }

  public void saveBooks(ArrayList<BookRecord> books) {
    try {
      FileWriter myWriter = new FileWriter(this.fileName);
      for (BookRecord bookRecord : books) {
        String authors = bookRecord.getAuthors().replace(",", "|");
        myWriter.write(bookRecord.getIsbn() + "," + bookRecord.getTitle() + "," + authors + "," + bookRecord.getPrice()
            + "," + bookRecord.getQuantity());
        myWriter.write("\n");
      }

      System.out.println();
      myWriter.close();
      System.out.println();

      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  /**
   * Each row will be stored in BookRecord Store the BookRecord object in
   * ArrayList Return the array list to the calling code
   * 
   * @return ArrayList of BookRecord
   */
  public ArrayList<BookRecord> loadBooks() {
    ArrayList<BookRecord> bookRecords = new ArrayList<BookRecord>();
    System.out.println();
    System.out.println("Reading inventory file " + this.fileName);
    System.out.println();
    try {
      Scanner sc = new Scanner(new File(this.fileName));
      while (sc.hasNextLine()) {
        String bookInfoLine = sc.nextLine();
        if (bookInfoLine.trim().length() == 0) {
          continue;
        }
        System.out.println(bookInfoLine);
        String[] bookInfoSplitted = bookInfoLine.split(",");
        bookInfoSplitted[2] = bookInfoSplitted[2].replace("|", ",");
        try {
          BookRecord bookRecord = new BookRecord(bookInfoSplitted[0], bookInfoSplitted[1], bookInfoSplitted[2],
              Double.parseDouble(bookInfoSplitted[3]), Integer.parseInt(bookInfoSplitted[4]));
          bookRecords.add(bookRecord);
        } catch (NumberFormatException ex) {
          System.out.println("NumberFormatException Error on line  " + bookInfoLine);
          System.out.println("Line  [" + bookInfoLine + "] is ignored.");
        }
      }

    } catch (FileNotFoundException e) {
      System.out.println("The file " + this.fileName + " was not found.");
    }
    System.out.println();
    System.out.println("Reading inventory file is done.");
    System.out.println();
    return bookRecords;
  }
}
