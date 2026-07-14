package Projects.Student_Notes_Management_System;

import java.io.*;
import java.util.Scanner;

public class Notes {
    public static void addNote(String fileName, Scanner sc) {
        try {

            FileWriter writer = new FileWriter(fileName, true);

            System.out.print("Write something about the note : ");
            String note = sc.nextLine();

            writer.write(note + "\n\n");
            System.out.println("Notes Added Successfully");

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void viewNote(String fileName) {
        try {

            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("No Notes Found");
                return;
            }
            BufferedReader buffer = new BufferedReader(new FileReader(fileName));
            String line;
            System.out.println("===== MY NOTES =====");
            System.out.println("--------------------");
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearNote(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            System.out.println("Clear All Notes Successfullly");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
