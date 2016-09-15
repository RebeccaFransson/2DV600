package rf222cz_assign2.Exercise3_JUnit;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import rf222cz_assign2.Exercise3_JUnit.rf222cz_assign2.Exercise1_Collection.ArrayIntListTest;
import rf222cz_assign2.Exercise3_JUnit.rf222cz_assign2.Exercise1_Collection.ArrayIntStackTest;

/**
 * Created by ymafr on 2016-09-14.
 */
public class CollectionTest {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));

        System.out.println("IntListTest");
        junit.run(ArrayIntListTest.class);

        System.out.println("IntStackTest");
        junit.run(ArrayIntStackTest.class);
    }

}
