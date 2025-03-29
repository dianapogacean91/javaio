package bufferedio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Use case for BufferedReader and BufferedWritter is for manipulating text files.
 */
public class ReadFromFileBuffered {
    public static void main(String[] args) throws IOException {


        try (BufferedReader br = new BufferedReader(new FileReader("textfile.txt"))) {

            String line;
            int c;
            do {
                line = br.readLine();
                c = br.read();
                if (line != null) {
                    System.out.println(line);
                    System.out.println((char)c);
                }
            } while (line != null);
        } catch (FileNotFoundException e) {

        }

//        try (BufferedReader br = new BufferedReader(new FileReader("textfile.txt"))) {
//
//            int c;
//            do {
//                c = br.read();
//
//                if (c != -1) {
//                    System.out.print((char) c);
//                }
//            } while (c != -1);
//        } catch (FileNotFoundException e) {
//
//        }
    }
}
