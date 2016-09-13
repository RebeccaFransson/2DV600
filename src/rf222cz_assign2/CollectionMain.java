package rf222cz_assign2;

/**
 * Created by ymafr on 2016-09-13.
 */
public class CollectionMain {
    public static void runIntList(){
        ArrayIntList intList = new ArrayIntList();

        System.out.println("---Empty list---");
        System.out.println(intList.toString()+"\n");

        intList.add(1);intList.add(2);intList.add(3);intList.add(4);
        intList.add(6);intList.add(7);intList.add(8);

        System.out.println("---Orginal list---");
        System.out.println(intList.toString()+"\n");

        intList.addAt(5, 4);
        System.out.println("---Added a 5, between 4 and 6---");
        System.out.println(intList.toString()+"\n");

        intList.addAt(55, 7);
        System.out.println("---Added a 55, between 7 and 8---");
        System.out.println("A resize have been done");
        System.out.println(intList.toString()+"\n");

        intList.remove(7);
        System.out.println("---Remove the number 55---");
        System.out.println(intList.toString()+"\n");

        System.out.println("---Get element with index 0---");
        System.out.println("The number is: "+intList.get(0)+"\n");

        System.out.println("---Get index from element 2---");
        System.out.println("The index is: "+intList.indexOf(2)+"\n");
    }

    public static void runIntStack(){
        ArrayIntStack intStack = new ArrayIntStack();

        System.out.println("---Empty stack---");
        System.out.println(intStack.toString()+"\n");

        intStack.push(1);intStack.push(2);intStack.push(3);

        System.out.println("---Orginal list---");
        System.out.println(intStack.toString()+"\n");

        System.out.println("---Remove top of stack---");
        System.out.println("Removed "+intStack.pop());
        System.out.println(intStack.toString()+"\n");

        System.out.println("---Peek stack---");
        System.out.println("Top of stack: "+intStack.peek());

    }

    public static void main(String[] args) {
        try{
            runIntList();
            System.out.println("\n------\n");
            runIntStack();

        }catch (IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }

    }

}
