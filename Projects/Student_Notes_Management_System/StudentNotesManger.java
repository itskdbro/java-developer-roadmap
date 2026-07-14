package Projects.Student_Notes_Management_System;

import java.io.*;
import java.util.Scanner;

public class StudentNotesManger {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final String FILE_NAME = "notes.txt";
        int choice = 0;

        do {

            System.out.println("====== Students Notes Manager ======");
            System.out.println("");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Clear All Notes");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.print("Enter choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    Notes.addNote(FILE_NAME, sc);
                    break;

                }
                case 2: {
                    Notes.viewNote(FILE_NAME);
                    break;
                }
                case 3: {
                    Notes.clearNote(FILE_NAME);
                    break;
                }
                case 4: {
                    System.out.println("Thanks for using Student Notes Manager");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }
        } while (choice != 4);

    }
}
