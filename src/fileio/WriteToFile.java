package fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {

    public static void main(String[] args) {

        String longString = "This is a very long string that we will write to a file using a small buffer size to demonstrate multiple iterations in the loop. "
                + "The quick brown fox jumps over the lazy dog. "
                + "Java I/O streams are powerful tools for handling input and output operations. "
                + "Buffered streams can improve performance by reducing the number of I/O operations.";


        //try with resources
        try (FileOutputStream fos = new FileOutputStream("textfile.txt")) {

            byte[] longStringBytes = longString.getBytes();
            byte[] buffer = new byte[10];

            int offset = 0;

            while (offset < longStringBytes.length){
                int length = Math.min(10, longStringBytes.length-offset);
                System.arraycopy(longStringBytes, offset, buffer, 0, length);
                fos.write(buffer, 0, length);
                offset += length;
            }

        } catch(FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Problem writing to stream: "+ e.getMessage());
        }

    }
}
