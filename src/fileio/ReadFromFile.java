package fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFromFile {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("textfile.txt")) {

            byte[] buffer = new byte[10];

            // -1 when no more characters available in file
            int nbBytesRead;
            do {
                nbBytesRead = fis.read(buffer);
                if (nbBytesRead != -1) {
                    for (int i = 0; i < nbBytesRead; i++) {

                        System.out.print((char) buffer[i]);
                    }
                }
            } while (nbBytesRead != -1);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Stream not closed. Reason: " + e.getMessage());
        }
    }
}
