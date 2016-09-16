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
            Set<Word> hash = new HashSet<Word>();
            Set<Word> tree = new TreeSet<Word>();
            //For each line, split it into words, add the words to the two sets.
            while (sc.hasNext()){
                String line = sc.nextLine();
                for (String word : line.split("\\s+")){
                    hash.add(new Word(word));
                    tree.add(new Word(word));
                }
            }
            //Print size of the sets
            System.out.println(hash.size());
            System.out.println(tree.size());
            //Print the words from treeset - alphabetical order
            for (Word w : tree) {
                System.out.println(w.toString());
            }

        }catch(FileNotFoundException e) {
            System.err.println("Couldn't find file");
            e.printStackTrace();
        }
    }
}

