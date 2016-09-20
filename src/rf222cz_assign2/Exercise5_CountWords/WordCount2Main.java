package rf222cz_assign2.Exercise5_CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-19.
 */
public class WordCount2Main {
    public static void main(String[] args) {
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";

        try(Scanner sc = new Scanner(new File(words))) {
            HashWordSet hws = new HashWordSet(10);//Put in the length of the buckets
            TreeWordSet tws = new TreeWordSet();

            //For each line, split it into words, add the words to the two sets.
            while (sc.hasNext()){
                for (String word : sc.nextLine().split("[\\s+]")){
                    if (!word.isEmpty()) {
                        hws.add(new Word(word.toLowerCase()));
                        tws.add(new Word(word.toLowerCase()));
                    }
                }
            }

            //Print all in hashset
            System.out.println("Hashset size: "+hws.size()+"\nWords:");
            System.out.println(hws.toString());

            //Print the words from treeSet - alphabetical order
            System.out.println("Treeset size: "+tws.size()+"\nWords:");
            System.out.println(tws.toString());

        }catch(FileNotFoundException e) {
            System.err.println("Couldn't find file");
            e.printStackTrace();
        }catch(NullPointerException e) {
            System.err.println("NullPointerException - "+e.getMessage());
            e.printStackTrace();
        }
    }
}
