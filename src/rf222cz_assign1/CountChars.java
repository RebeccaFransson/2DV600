package rf222cz_assign1;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-02.
 */
public class CountChars {

    public static void main(String[] args) throws IOException {

        System.out.println("----Welcome to CountChars----");
        //String file = "C:\\Users\\ymafr\\IdeaProjects\\2DV600\\src\\rf222cz_assign1\\SergioGarciaBeatsTheAmericans.txt";
        String file = args[0];

        File text = new File(file);
        System.out.println("Reading file: " + text.getAbsolutePath());

        int upperCase = 0, lowerCase = 0, whitespace = 0, all = 0, other = 0, number = 0;

        try(Scanner sc = new Scanner(text)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();

                //Count all caracters
                all += line.length();

                //Count whitespaces, Lower and Upper case letters
                for (int k = 0; k < line.length(); k++) {
                    if (Character.isWhitespace(line.charAt(k))) whitespace++;
                    else if (Character.isUpperCase(line.charAt(k))) upperCase++;
                    else if (Character.isLowerCase(line.charAt(k))) lowerCase++;
                    else if (Character.isDigit(line.charAt(k))) number++;
                }

            }
            other = all - (whitespace + upperCase + lowerCase + number);

        }
        catch (FileNotFoundException e) { e.printStackTrace(); }


        System.out.println("Whitespaces: \t"+whitespace);
        System.out.println("Upper case: \t"+upperCase);
        System.out.println("Lower case: \t"+lowerCase);
        System.out.println("Numbers : \t\t"+number);
        System.out.println("Other : \t\t"+other);



    }
}
