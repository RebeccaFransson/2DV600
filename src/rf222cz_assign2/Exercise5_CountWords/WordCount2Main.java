package rf222cz_assign2.Exercise5_CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-19.
 */
public class WordCount2Main {
    public static void main(String[] args) {
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";

        try(Scanner sc = new Scanner(new File(words))) {
            HashWordSet hws = new HashWordSet(7);
            //For each line, split it into words, add the words to the two sets.
            while (sc.hasNext()){
                String line = sc.nextLine();
                for (String word : line.split(" +")){
                    if (!word.isEmpty())
                        hws.add(new Word(word));
                }
            }
            //Print size of the sets
            System.out.println(hws.toString());
            System.out.println("size: "+hws.size());
            //Print the words from treeSet - alphabetical order

        }catch(FileNotFoundException e) {
            System.err.println("Couldn't find file");
            e.printStackTrace();
        }catch(NullPointerException e) {
            System.err.println("NullPointerException - "+e.getMessage());
            e.printStackTrace();
        }
    }
}
