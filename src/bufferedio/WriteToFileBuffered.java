package bufferedio;

import java.io.*;

public class WriteToFileBuffered {

    public static void main(String[] args) throws IOException {
        String longString = "This is a very long string that we will write to a file using a small buffer size to demonstrate multiple iterations in the loop. "
                + "The quick brown fox jumps over the lazy dog. "
                + "Java I/O streams are powerful tools for handling input and output operations. "
                + "Buffered streams can improve performance by reducing the number of I/O operations.";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("writebuffered.txt"))) {
            bw.write(longString, 10, 150);
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
