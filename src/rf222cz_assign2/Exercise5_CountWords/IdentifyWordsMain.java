package rf222cz_assign2.Exercise5_CountWords;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-16.
 */
public class IdentifyWordsMain {
    public static void main(String[] args) {
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";

        if(args.length == 0){
            System.err.println("The program needs a filename to run");
            System.exit(1);
        }
        readAndWrite(args[0], words);
    }

    public static void readAndWrite(String readFrom, String writeTo){
        //Reading file, strip every line from tings that isn't words - print to words.txt.
        try(Scanner sc = new Scanner(new File(readFrom))) {
            System.out.println("Reading file: " + readFrom);
            try(FileWriter out = new FileWriter(writeTo)){
                System.out.println("writing to file: " + writeTo);
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    //replaceAll 1 removes the character after numbers (there is a 1940s in the text)
                    //replaceAll 2 And keep only words with a-z
                    out.write(line.replaceAll("[a-z]*$", "").replaceAll("[^A-Za-z\\s]+", ""));
                }
            }
        }catch(FileNotFoundException e) {
            System.err.println("Couldn't find file");
            e.printStackTrace();
        }catch(IOException e) {
            System.err.println("Something went wrong with reading/writing text");
            e.printStackTrace();
        }
    }
}
