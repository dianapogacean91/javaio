package fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FromFileToFile {


    public static void main(String[] args) throws IOException {
        try (FileInputStream fis = new FileInputStream("textfile.txt"); FileOutputStream fos = new FileOutputStream("destination.txt")){
            byte[] buffer = new byte[10];
            int bytesRead;

            do {
                bytesRead = fis.read(buffer);
                if (bytesRead > 0) {
                    fos.write(buffer, 0, bytesRead);
                }
            } while(bytesRead!=-1);

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
