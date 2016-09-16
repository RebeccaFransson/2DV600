package rf222cz_assign1;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-08-31.
 */
public class HighLow {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("----Welcome to HighLow----");
        System.out.println("I have a secret number for you, can you guess it?");
        System.out.println("--------------------------");

        int count = 1;
        int maxguesses = 10;
        //create random nr
        Random rand = new Random();
        int randomNum = rand.nextInt((100 - 1) + 1) + 1;

        while (count < maxguesses){
            System.out.print("Guess nr "+count+": ");

            String guessText = scan.nextLine();

            try{
                int guess = Integer.parseInt(guessText);
                if(guess > 100 || guess < 1 && guess%2 == 0){
                    System.err.println("I need a ODD number between 1-100, try again:");
                }else if(guess > randomNum){
                    System.out.println("Sorry, its lower!");
                    count++;
                }else if(guess < randomNum){
                    System.out.println("Naaaj, its higher!");
                    count++;
                }else if(guess == randomNum){
                    System.out.println("Yeeey, you guessed right! The secret number was "+randomNum+". It only took "+count+" guess/guesses");
                    break;
                }


            }catch (NumberFormatException e){
                System.err.println("I need a number between 1-100, try again:");
            }


        }
        System.out.print("Sorry! You are out of turns, try again!");

    }
}
