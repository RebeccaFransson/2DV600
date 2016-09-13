package rf222cz_assign2;

/**
 * Created by ymafr on 2016-09-13.
 */
public class CollectionMain {

    public static void main(String[] args) {
        try{
            ArrayIntList intList = new ArrayIntList();

            System.out.println(intList.toString());
            intList.add(1);
            intList.add(2);
            intList.add(3);
            intList.add(4);
            intList.add(4);
            intList.add(6);
            intList.add(7);
            System.out.println(intList.toString());

            intList.addAt(5, 4);
            System.out.println(intList.toString());

        }catch (IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }

    }

}
