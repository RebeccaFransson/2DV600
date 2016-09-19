package rf222cz_assign2.Exercise5_CountWords;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-16.
 */
public class IdentifyWordsMain {
    public static void main(String[] args) {

        String file = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\HistoryOfProgramming.txt";
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";

        /*if(args.length == 0){
            System.err.println("The program needs a filename to run");
            System.exit(1);
        }*/

        readAndWrite(file, words);

    }

    public static void readAndWrite(String readFrom, String writeTo){
        //Reading file, strip every line from tings that isn't words - print to words.txt.
        try(Scanner sc = new Scanner(new File(readFrom))) {
            System.out.println("Reading file: " + readFrom);
            try(FileWriter out = new FileWriter(writeTo)){
                System.out.println("writing to file: " + writeTo);
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    //replaceAll 1 Translate hyphen words into two words.
                    //replaceAll 2 And keep only words with a-z
                    out.write(line.replaceAll("[\\-]", " ").replaceAll("[']*[^a-zA-Z\\s]", "") + "\n");
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
