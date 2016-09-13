package rf222cz_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-06.
 */
public class Histogram {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("----Welcome to Histogram----");

        //String file = "C:\\Users\\ymafr\\IdeaProjects\\2DV600\\src\\rf222cz_assign1\\integers.dat";


        try{
            if(args.length == 0){
                throw new IOException("No file found");
            }

            File text = new File(args[0]);

            System.out.println("Reading file: " + text.getAbsolutePath());

            try(Scanner sc = new Scanner(text)) {
                List<Integer> intList = new ArrayList<Integer>();

                int oneToHundred = 0;
                int hundredToTwohundred = 0;

                //turns the integer-file to a array with the numbers between 1-200
                while (sc.hasNextInt()) {
                    int number = sc.nextInt();

                    if(number > 0 && number < 200){
                        intList.add(number);
                    }
                    if(number > 0 && number < 100) oneToHundred++;
                    else if(number > 100 && number < 200) hundredToTwohundred++;
                }

                System.out.println("Number of integers in the interval [1,100]:"+oneToHundred);
                System.out.println("in the interval [101,200]:"+hundredToTwohundred);

                System.out.println("\nHistogram");

                //for as long that count isnt bigger than 11
                //Count digits in the firs intervall
                //Change the intervall start and stop and loop again.
                int leng = 11;
                int count = 0;
                int intervallStart = 1;
                int intervallStop = 10;

                while (count < leng){
                    System.out.print("\n"+intervallStart+" - "+intervallStop+"\t | ");
                    for (int i = 0; i < intList.size(); i++){
                        if(intList.get(i) >= intervallStart && intList.get(i) <= intervallStop) System.out.print("*");
                    }
                    //if intervallstop is 100 jump it to 200. Else just add 10
                    intervallStop = ((intervallStop == 100) ? 200 : intervallStop+10);
                    intervallStart = intervallStart+10;
                    count++;
                }

            }catch (FileNotFoundException e) { System.err.println("No file found");}
        }catch (IOException e) { System.err.println(e.getMessage());}
    }
}
