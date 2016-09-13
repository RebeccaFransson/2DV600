package rf222cz_assign1;

import java.io.IOException;
import java.util.Comparator;

/**
 * Created by ymafr on 2016-09-04.
 */
public class Arrays {

    int sum(int[] arr){//adds all elements in the array and returns the sum
        int sum = 0;
        for( int num : arr) {
            sum = sum+num;
        }
        return sum;
    }

    String toString(int[] arr){
        String str = "{";
        for (int i = 0; i < arr.length; i++)
            str += arr[i]+" ";
        return str+"}";
    }

    int[] addN(int[] arr, int n){//Adds the number N to all elements in the array
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i]+n;
        return arr;
    }

    public int[] reverse(int[] arr){
        int[] reverseArr = new int[arr.length];
        System.arraycopy(arr, 0, reverseArr, 0, arr.length);
        //splits the array and replaces the first with the last element all the way thru the array
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = reverseArr[i];
            reverseArr[i] = reverseArr[reverseArr.length - i - 1];
            reverseArr[reverseArr.length - i - 1] = temp;
        }
        return reverseArr;
    }

    void replaceAll(int[] arr, int old, int nw){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == old) arr[i] = nw;
    }

    int[] sort(int[] arr){
        int[] sortArr = new int[arr.length];
        System.arraycopy(arr, 0, sortArr, 0, arr.length);

        java.util.Arrays.sort(sortArr);
        return sortArr;
        /*int i, x;
        int temp;
        for(i = 0; i < sortArr.length -1; i++){
            for(x = 0; x < sortArr.length -1; x++) {
                if(arr[x] > sortArr[x+1]) {
                    temp = sortArr[x];
                    sortArr[x] = sortArr[x + 1];
                    sortArr[x + 1] = temp;
                }
            }
        }
        return sortArr;*/
    }

    boolean hasSubsequence(int[] arr, int[] sub){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == sub[0]){
                for (int x = 0; x < sub.length; x++){
                    if(arr[i+x] == sub[x]){
                        count++;
                    }
                    if(count == sub.length){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    int[] absDif(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return null;
        }
        int[] difArr = new int[arr1.length];
        System.arraycopy(arr1, 0, difArr, 0, arr1.length);
        for (int i = 0; i < difArr.length; i++){
            difArr[i] = arr1[i] - arr2[i];
        }
        return difArr;
    }


    public static void main(String[] args) throws IOException {
        Arrays methods = new Arrays();

        int[] test = {1,5,3,4,2}, diffArr = {1,1,1,1}, subTrue = {5,3, 4}, subFalse = {1,5,4};


        try{

            System.out.println("The sum: "+methods.sum(test));
            System.out.println("Subsequence is true: "+methods.hasSubsequence(test, subTrue));
            System.out.println("Subsequence is false: "+methods.hasSubsequence(test, subFalse));

            System.out.println("\n-----BEFORE replacing 5 to 7-------");
            System.out.println(methods.toString(test));
            System.out.println("-----AFTER-------");
            methods.replaceAll(test, 5, 7);
            System.out.println(methods.toString(test));
            System.out.println("------------\n\n");

            System.out.println("-----BEFORE Adding 1 to all numbers-------");
            System.out.println(methods.toString(test));
            System.out.println("-----AFTER-------");
            methods.addN(test, 1);
            System.out.println(methods.toString(test));
            System.out.println("------------\n\n");

            System.out.println("-----BEFORE reversing array-------");
            System.out.println(methods.toString(test));
            System.out.println("-----AFTER-------");
            System.out.println(methods.toString(methods.reverse(test)));
            System.out.println("------------\n\n");

            System.out.println("-----BEFORE sorting array-------");
            System.out.println(methods.toString(test));
            System.out.println("-----AFTER-------");
            System.out.println(methods.toString(methods.sort(test)));
            System.out.println("------------\n\n");

            System.out.println("-----BEFORE differenting-------");
            System.out.println(methods.toString(test));
            System.out.println("-----AFTER-------");
            int[] newArr = methods.absDif(test, diffArr);
            if(newArr == null){
                throw new IOException("Not the same length in array");
            }
            System.out.println(methods.toString(newArr));
            System.out.println("------------\n\n");

        }catch(IOException e){
            System.err.println(e);
        }
    }


}
