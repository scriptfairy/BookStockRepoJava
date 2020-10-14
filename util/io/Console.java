package util.io;

import java.util.Scanner;

/**
 * Console is singleton. Use only one instance of the Scanner attached to
 * System.in, If we try to use multiple scanners we get error message.
 */
public class Console {

    private static Scanner scanner;

    public static void open() {
        Console.scanner = new Scanner(System.in);
    }

    public static String nextLine() {
        return Console.scanner.nextLine();
    }

    public static double nextDouble() {
        double d = Console.scanner.nextDouble();
        Console.scanner.nextLine(); // Read trailing new line character
        return d;
    }

    public static int nextInt() {
        int i = Console.scanner.nextInt();
        Console.scanner.nextLine(); // Read trailing new line character
        return i;
    }

    public static void close() {
        Console.scanner.close();
    }

}
