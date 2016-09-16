package rf222cz_assign2.Exercise5_CountWords;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-16.
 */
public class IdentyfyWordsMain {
    public static void main(String[] args) {

        String file = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\HistoryOfProgramming.txt";
        String words = "C:\\Users\\ymafr\\OneDrive\\Dokument\\GitHub\\2DV600\\src\\rf222cz_assign2\\Exercise5_CountWords\\Words.txt";
        File text = new File(file);
        System.out.println("Reading file: " + text.getAbsolutePath());

        try(Scanner sc = new Scanner(text)) {
            try(FileWriter out = new FileWriter(words)){
                while(sc.hasNextLine()) {
                    String line = sc.nextLine();
                    out.write(line.replaceAll("[\\-]", " ").replaceAll("[']*[^a-zA-Z\\s]", "") + "\n");
                }
            }catch(IOException e) {
                System.err.println("Couldnt write to words.txt");
                e.printStackTrace();
            }
        }catch(FileNotFoundException e) {
            System.err.println("Couldnt get text from HistoryOfProgramming.txt");
            e.printStackTrace();
        }
    }
}
