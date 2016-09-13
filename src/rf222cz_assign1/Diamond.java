package rf222cz_assign1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-09-02.
 */
public class Diamond {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("----Welcome to Dimond----");
        System.out.println("Insert a number to make a dimond: ");

        String dimondText = scan.nextLine();


        try {
            int numberOfStars = Integer.parseInt(dimondText);

            if(numberOfStars%2 == 0 || numberOfStars > 1){
                System.out.println("Insert a positive and ODD number, try again: ");
                numberOfStars  = scan.nextInt();
            }

            //getting the midrow
            int midrow = numberOfStars / 2;
            for (int i = midrow; i >= -numberOfStars / 2; i--) {
                //first pyramid, from 1 to max
                for (int k = 0; k < i; k++) {
                    //Printing spaces
                    System.out.print(" ");
                }
                for (int j = 1; j <= (numberOfStars - i * 2) && i >= 0; j++) {
                    //Sprinting stars at the end of each row
                    System.out.print("*");
                }
                //second pyramid from almost max to 1
                for (int k = 1; k <= -i && i < 0; k++) {
                    System.out.print(" ");
                }
                for (int j = midrow * 2 + 2 * i; j >= -(numberOfStars % 2 - 1) && i < 0; j--) {
                    System.out.print("*");
                }
                System.out.println();
            }


        }catch (NumberFormatException e){
            System.err.println("I need a odd number, try again...");
        }

    }

}
