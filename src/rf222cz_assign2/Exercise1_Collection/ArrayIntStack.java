package rf222cz_assign2.Exercise1_Collection;

/**
 * Created by ymafr on 2016-09-13.
 */
public class ArrayIntStack extends da1031.AbstractIntCollection implements da1031.IntStack {

    @Override
    public void push(int n) {
        for (int i = size(); i > 0; i--){
            values[i] = values[i - 1];
        }
        values[0] = n;
        size++;
        if(size() >= values.length)
            resize();
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        if(size() == 0){
            throw new IndexOutOfBoundsException("pop() -- Cant remove when the stacksize is zero");
        }
        int remove = values[0];
        for (int i = 0; i < size(); i++){
            values[i] = values[i + 1];
        }
        size--;
        return remove;
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if(size() == 0){
            throw new IndexOutOfBoundsException("peek() -- Cant get value when the stacksize is zero");
        }
        return values[0];
    }
}
