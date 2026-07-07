package Day4.Collection.MiniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> books = new ArrayList<>();

        books.add("Python prog");
        books.add("Java Programming");
        books.add("AI vs Human");
        books.add("C++ prog");
        books.add("Computer networking");

        System.out.println("Available books : ");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println("----------------------");

        System.out.print("Issue a book : ");
        String issuedBook = sc.nextLine();
        if (books.remove(issuedBook)) {
            System.out.println(issuedBook + " book issued successfully");
        } else {
            System.out.println("Book not found");
        }
        System.out.println("----------------------");

        System.out.print("Add a book : ");
        String newBook = sc.nextLine();
        if (!newBook.isBlank() && !books.contains(newBook)) {
            books.add(newBook);
        }
        System.out.println("Updated books List : ");
        for (String book : books) {
            System.out.println(book);
        }

        System.out.println("----------------------");
        boolean bookExists = books.contains("Java Programming");
        System.out.println("Java Programming exists : " + bookExists);

        System.out.println("----------------------");
        System.out.println("Total books : " + books.size());

    }
}
