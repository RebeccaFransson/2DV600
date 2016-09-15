package rf222cz_assign2.Exercise3_JUnit.rf222cz_assign2.Exercise1_Collection;

import org.junit.Before;
import org.junit.Test;
import rf222cz_assign2.Exercise1_Collection.ArrayIntStack;

import static org.junit.Assert.*;

/**
 * Created by ymafr on 2016-09-14.
 */
public class ArrayIntStackTest {

    private static int count = 0;

    @Before
    public void beforeTest(){
        count++;
        System.out.print("Test nr: "+count+" - ");
    }

    @Test
    public void testPush(){
        System.out.println("Push()");
        //Pushing 10 new elements into stack, then check if they are added.
        ArrayIntStack intStack = pushMany(10);
        assertEquals(10, intStack.size());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPop(){
        System.out.println("Pop()");
        //Popping out one element and check if size has changed
        ArrayIntStack intStack = pushMany(10);
        int size = intStack.size();

        intStack.pop();
        assertNotEquals(size, intStack.size());

        //Forcing exception with pop on empty stack
        ArrayIntStack intStack2 = new ArrayIntStack();
        intStack2.pop();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPeek(){
        System.out.println("Peek()");
        //Peeking out a element from the stack,
        // check if the peeked element is equal to last added element
        ArrayIntStack intStack = pushMany(10);

        assertEquals(9, intStack.peek());

        //Forcing exception with peek on empty stack
        ArrayIntStack intStack2 = new ArrayIntStack();
        intStack2.peek();
    }

    @Test
    public void testIsEmpty(){
        System.out.println("IsEmpty()");

    }

    private ArrayIntStack pushMany(int size) {
        ArrayIntStack intStack = new ArrayIntStack();
        for (int i = 0; i < size; i++)
            intStack.push(i);
        return intStack;
    }

}