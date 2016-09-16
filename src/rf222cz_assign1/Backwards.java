package rf222cz_assign1; /**
 * Created by ymafr on 2016-08-30.
 */

import java.util.Scanner;
import java.io.IOException;

public class Backwards {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("----Welcome to Backwards----");
        System.out.print("Insert text: ");

        String text = scan.nextLine (); // read text as a string
        if(text != null && !text.isEmpty()){
            StringBuilder sb = new StringBuilder(text); //inmatade texten
            sb.reverse();
            System.out.println("Reversed text: "+sb.toString()); // print string

        }else{
            System.err.println("Cannot be empty, enter text again: ");
            text = scan.nextLine (); // read text as a string again
        }
    }
}
