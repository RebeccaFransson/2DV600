package rf222cz_assign2.Exercise5_CountWords;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by ymafr on 2016-09-16.
 */
public class WordTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        junit.run(WordTest.class);
    }

    @Test
    public void testEquals() {
        System.out.println("testEquals()");
        Word w = new Word("hello");
        assertTrue(w.equals(new Word("HELLO")));
    }

    @Test
    public void testCompareTo() {
        System.out.println("testCompareTo()");
        Word w = new Word("Hello");
        //exicographically equivalents
        assertEquals(0, w.compareTo(w));

        //Hello comes before Heather
        boolean compare = false;
        if(w.compareTo(new Word("Heather")) > 0)
            compare = true;
        assertTrue(compare);

        //Hello comes after January
        compare = false;
        if(w.compareTo(new Word("January")) < 0)
            compare = true;
        assertTrue(compare);
    }
}
