package rf222cz_assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Created by ymafr on 2016-08-30.
 */


public class LargestK {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("----Welcome to largest K----");
        System.out.println("Insert a number");

        String Nr = scan.nextLine();

        try {
            int N = Integer.parseInt(Nr);

            if(N < 3){
                System.err.println("Number cant be smaller then three, try again: ");
                Nr = scan.nextLine();
                N = Integer.parseInt(Nr);
            }
            List<Integer> K = new ArrayList<Integer>(N);

            //declare sum
            int sum = 0;

            while(N >= sum){
                if(K.size() == 0){//if its the first insert, insert two
                    K.add(2);
                }else{
                    int size = K.size()-1;//minus one because the array starts with 0
                    int add = K.get(size);
                    K.add(add+2);
                }
                //get the sum of the array
                sum = 0;
                for(int i = 0; i < K.size(); i++)
                    sum += K.get(i);

            }
            if(N < sum){ //if its over N then take away the last element and we have the highet K
                K.remove(K.size()-1);
            }

            System.out.println("Largest K is: " + Collections.max(K));
            System.out.println(K);

        } catch(NumberFormatException e) {
            System.err.println("Invalid format, try again");
        }
    }
}
