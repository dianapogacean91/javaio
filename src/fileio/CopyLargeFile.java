package fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyLargeFile {

    //The use case for FileInputStream and FileOutputStream is manipulating  BINARY files.
    public static void main(String[] args) throws IOException {


        long startTime = System.currentTimeMillis();
        int nbIterations = 0;

        try (FileInputStream fis = new FileInputStream("photo.jpeg"); FileOutputStream fos = new FileOutputStream("photocopy.jpeg")) {

            //1KB = 1024 B
            //2KB = 2048 B
            //3Kb = 3072 B
            //4kb = 4096 B

            byte[] buffer = new byte[1];
            int bytesRead;


            do {
                bytesRead = fis.read(buffer);
                if (bytesRead != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                nbIterations++;
            } while (bytesRead != -1);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Program execution time: " + (endTime - startTime) + ", nb iterations: " + nbIterations);
    }
}
