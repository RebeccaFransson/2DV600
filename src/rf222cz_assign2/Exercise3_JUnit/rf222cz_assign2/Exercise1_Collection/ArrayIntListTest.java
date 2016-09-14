package rf222cz_assign2.Exercise1_Collection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ymafr on 2016-09-14.
 */
public class ArrayIntListTest {
    @Test
    public void add() throws Exception {
        ArrayIntList intList = new ArrayIntList();
        intList.add(1);
    }

    @Test
    public void addAt() throws Exception {

    }

    @Test
    public void remove() throws Exception {

    }

    @Test
    public void get() throws Exception {
        ArrayIntList intList = new ArrayIntList();
        intList.add(1);
        //Get the first element
        assertEquals(1, intList.get(0));
    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void indexOf() throws Exception {

    }

}