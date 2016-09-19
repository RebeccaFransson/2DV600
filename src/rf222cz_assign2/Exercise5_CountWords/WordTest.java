package rf222cz_assign2.Exercise5_CountWords;

import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

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

    @Test
    public void testNotEquals(){
        System.out.println("testNotEquals()");
        Word w = new Word("hello");
        assertFalse(w.equals(1));
    }

    @Test
    public void testHashCode(){
        Word w = new Word("Hello");
        Word w2 = new Word("loelh");

        assertEquals(w.hashCode(), w2.hashCode());
    }
}
