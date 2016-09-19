package rf222cz_assign2.Exercise3_JUnit.rf222cz_assign2.Exercise1_Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.IOP.ExceptionDetailMessage;
import rf222cz_assign2.Exercise1_Collection.ArrayIntList;

import static org.junit.Assert.*;

/**
 * Created by ymafr on 2016-09-14.
 */
public class ArrayIntListTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static int count = 0;

    @Before
    public void beforeTest(){
        count++;
        System.out.print("Test nr: "+count+" - ");
    }

    @Test
    public void testAddAt(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("AddAt()");
        //Testing to add 55 between 7 and 8
        int addValue = 55;
        ArrayIntList intList = addMany(10);
        intList.addAt(55, 7);
        //Getting it soo se if its equal to the addValue
        assertEquals(addValue, intList.get(7));

        //Force exception with addat with an index that is out of bounds
        intList.addAt(20, 20);
    }

    @Test
    public void testAddHugeAmount() {
        System.out.println("AddHugeAmount()");
        ArrayIntList intList = addMany(10000000);
        assertEquals(10000000, intList.size());
    }

    @Test
    public void testIndexOf(){
        System.out.println("IndexOf()");
        //testing to get index of a element
        //Array looks like this: [ 0 1 2 3 4 5 6 7 8 9 ]
        ArrayIntList intList = addMany(10);
        assertEquals(5, intList.indexOf(5));
    }

    @Test
    public void testRemoveNSize(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("RemoveNSize()");
        //Creating a list and then removing.
        //The first-list size should not be equal to the removed-list size.
        ArrayIntList intList = addMany(10);
        int firstSize = intList.size();
        intList.remove(2);
        assertNotEquals(firstSize, intList.size());

        //Force exception with remove with an index that is out of bounds
        intList.remove(20);
    }

    @Test
    public void testGet(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("Get()");
        //testing to get the first element after adding it
        ArrayIntList intList = new ArrayIntList();
        intList.add(1);

        assertEquals(1, intList.get(0));


        //Force exception(and catching it) with remove with an index that is out of bounds
        intList.get(2);

    }
    @Test
    public void testAdd() {
        System.out.println("Add()");
        //Adds 10 new elements then check if they are added.
        ArrayIntList intList = addMany(10);
        assertEquals(10, intList.size());
    }

    @Test
    public void testIsEmpty(){
        System.out.println("IsEmpty()");
        //Creates new list check if empty
        ArrayIntList intList = new ArrayIntList();
        assertEquals(true, intList.isEmpty());

        //Adds element to list and then checks if empty again
        ArrayIntList intList2 = addMany(10);
        assertEquals(false, intList2.isEmpty());
    }


    //Help method
    private ArrayIntList addMany(int size) {
        ArrayIntList intList = new ArrayIntList();
        for (int i = 0; i < size; i++)
            intList.add(i);
        return intList;
    }

}