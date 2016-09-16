package rf222cz_assign2.Exercise4_Queue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ymafr on 2016-09-16.
 */
public class QueueTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        junit.run(QueueTest.class);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private static int count = 0;

    @Before
    public void beforeTest(){
        count++;
        System.out.print("Test nr: "+count+" - ");
    }

    @Test
    public void testEnqueueNSize(){
        System.out.println("EnqueueNSize()");
        Queue q = enqueueMany(10000000);
        assertEquals(10000000-1, q.size());//Minus one because EnqueueMany start with one
    }

    @Test
    public void testDequeueNEmpty(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("DequeueNEmpty()");

        //Force exception, dequeue on empty array
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.dequeue();

        q = enqueueMany(10);
        int firstSize = q.size();
        q.dequeue();
        assertNotEquals(firstSize, q.size());
    }

    @Test
    public void testFirst(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("First()");

        //Force exception with first on empty array
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.first();

        q = enqueueMany(10);
        assertEquals(1, q.first());

    }

    @Test
    public void testLast(){
        exception.expect(IndexOutOfBoundsException.class);
        System.out.println("Last()");

        //Force exception with first on empty array
        Queue q = new Queue();
        assertTrue(q.isEmpty());
        q.last();

        q = enqueueMany(10);
        assertEquals(10, q.last());

    }

    //Help method
    private Queue enqueueMany(int size) {
        Queue q = new Queue();
        for (int i = 1; i < size; i++)
            q.enqueue(i);
        return q;
    }
}
