package rf222cz_assign1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ymafr on 2016-08-31.
 */
public class CountDigits {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("----Welcome to CountDigits----");
        System.out.print("Insert some numbers without space: ");

        String digits = scan.nextLine(); // read numbers as a String at first

        if(digits.contains(" ")){
            System.err.println("The number cant contain any spaces try again: ");
            digits = scan.nextLine();
        }

        int sum = 0;
        for (char c: digits.toCharArray())
            sum += c - '0';

        try{
            int numbers = Integer.parseInt(digits);
            int evenCount = 0, oddCount = 0, zeroCount = 0;

            //Stripping away to one number and then checking if odd,even or zero.
            //Doing the same for all digits
            while (numbers > 0) {
                if ((numbers%10)==0) {
                    zeroCount++;
                }else if (numbers%2==0) {
                    evenCount++;
                }else{
                    oddCount++;
                }
                numbers /= 10;
            }

            System.out.println("Zeros: "+zeroCount);
            System.out.println("Even: "+evenCount);
            System.out.println("Odd: "+oddCount);
            System.out.println("Sum: "+sum);

        }catch(NumberFormatException e){
            System.err.println("Invalid format, try again");
        }

    }
}
