package Day9_FileHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("student.txt"));

            String line;
            while ((line = buffer.readLine()) != null) {
                System.out.println(line);
            }

            buffer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
