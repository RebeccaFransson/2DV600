package rf222cz_assign2.Exercise5_CountWords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ymafr on 2016-09-16.
 */
public class WordCount1Main {
    public static void main(String[] args) {
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";

        try(Scanner sc = new Scanner(new File(words))) {
            //Creates empty sets
            Set<Word> tree = new TreeSet<Word>();
            Set<Word> hash = new HashSet<Word>();
            //For each line, split it into words, add the words to the two sets.
            while (sc.hasNext()){

                for (String word : sc.nextLine().split("[\\s+]")){
                    hash.add(new Word(word.toLowerCase()));
                    tree.add(new Word(word.toLowerCase()));
                }
            }
            //Print the words from treeSet - alphabetical order
            for (Word w : tree) {
                System.out.println("'"+w.toString()+"'");
            }

            //Print size of the sets
            System.out.println("HashSet size: "+hash.size());
            System.out.println("TreeSet size: "+tree.size());

        }catch(FileNotFoundException e) {
            System.err.println("Couldn't find file");
            e.printStackTrace();
        }
    }
}

