package rf222cz_assign2.Exercise3_JUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import rf222cz_assign2.Exercise1_Collection.ArrayIntList;
import rf222cz_assign2.Exercise3_JUnit.rf222cz_assign2.Exercise1_Collection.ArrayIntListTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by ymafr on 2016-09-14.
 */
public class CollectionTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(ArrayIntListTest.class);
    }

    private int count = 0;
    @Before
    public void beforeTest(){
        count++;
        System.out.println("Test nr: "+count);
    }

}
