package Day9_FileHandling;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("student.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("file created successfully");
            } else System.out.println("file already exists");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
