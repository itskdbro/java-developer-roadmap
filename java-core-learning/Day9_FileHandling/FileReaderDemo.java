package Day9_FileHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("student.txt");

            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println((char) ch);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
