package Day9_FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        try {
//            FileWriter writer = new FileWriter("student.txt");  --> Overwrite
            FileWriter writer = new FileWriter("student.txt", true);  // ---> append data

            writer.write("Name : Keshav\n");
            writer.write("Role : Java Developer\n");
            writer.write("Company : TCS\n");

            writer.close();
            System.out.println("Data written successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
