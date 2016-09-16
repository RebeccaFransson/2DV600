package rf222cz_assign2.Exercise4_Queue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;

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
    public void testEnqueue(){
        
    }
}
