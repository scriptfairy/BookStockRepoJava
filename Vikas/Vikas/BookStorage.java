import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * BookStorage is responsible for saving and loading books
 * from a file.
 *
 * The book data will stored in a file named books.txt
 *
 * books.txt file will have the following format:
 *
 * ISBN,Book Title,Author 1|Author 2|Author 3,Price,Quantity
 *
 *
 */

public class BookStorage{

    private static String fileName = "books.txt";

    /**
     * Each row will be stored in BookRecord
     * Store the BookRecord object in ArrayList
     * Return the array list to the calling code
     * @return ArrayList of BookRecord
     */
    public static void createBookFile(){
        // TODO read the file and return the stored booked.
        try {
          File fileObj = new File(fileName);
          if (fileObj.createNewFile()) {
            System.out.println("File created: " + fileObj.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }
    /**
     * Input is ArrayList of BookRecord
     * The method will overwrite the data in the books.txt with the
     * the records in books
     */
    public static void saveBooks(ArrayList<BookRecord> books){
        try {
          FileWriter myWriter = new FileWriter(fileName);
          for(BookRecord bookRec : books) {
            //If(doesBookExists()) {

            //} else {
            String authors = "";
            Boolean flag = true;
            for(String author : bookRec.authors) {
              if(flag) {
                authors += author;
                flag = false;
              } else {
                authors += "," + author;
              }
            }
            myWriter.write(bookRec.isbn + "|" + bookRec.title + "|" + authors + "|" + bookRec.price + "|" + bookRec.quantity);
            myWriter.write("\n");
          }
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    /**
     * Each row will be stored in BookRecord
     * Store the BookRecord object in ArrayList
     * Return the array list to the calling code
     * @return ArrayList of BookRecord
     */
    public static ArrayList<BookRecord> loadBooks(String filePathName)
                                        throws FileNotFoundException {
        // TODO read the file and return the stored booked.
        // pass the path to the file as a parameter
        ArrayList<BookRecord> bookRecs = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePathName));

        while (sc.hasNextLine()) {
          String bookInfoLine = sc.nextLine();

          System.out.println("=====bookInfoLine=====" + bookInfoLine);
          String[] bookInfoSplitted = bookInfoLine.split("\\|");
          //System.out.println("=====bookInfoSplitted=====" + bookInfoSplitted[1]);
          //System.out.println("=====bookInfoSplitted=====" + bookInfoSplitted[2]);

          ArrayList<String> authors = new ArrayList<>();
          String[] authersSplitted = bookInfoSplitted[2].split(",");
          for(int  i = 0; i < authersSplitted.length; i++) {
            System.out.println("Author: " + authersSplitted[i]);
            authors.add(authersSplitted[i]);
          }

          BookRecord bookRecord = new BookRecord(bookInfoSplitted[0], bookInfoSplitted[1], authors, Double.parseDouble(bookInfoSplitted[3]), Integer.parseInt(bookInfoSplitted[4]));
          bookRecs.add(bookRecord);
        }

        System.out.println("====Books=====");
        System.out.println("====Books=====" + bookRecs);
        return bookRecs;
    }

    public static Boolean doesBookExists() {

      return false;
    }

}
