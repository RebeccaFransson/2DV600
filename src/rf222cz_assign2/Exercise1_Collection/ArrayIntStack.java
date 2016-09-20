package rf222cz_assign2.Exercise1_Collection;

/**
 * Created by ymafr on 2016-09-13.
 */
public class ArrayIntStack extends da1031.AbstractIntCollection implements da1031.IntStack {

    //Pushes in a element first in the list
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

    //Taking out the first element in the list and removes it
    @Override
    public int pop() throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("pop() -- Cant remove when the stacksize is zero");
        }
        int remove = values[0];
        for (int i = 0; i < size(); i++){
            values[i] = values[i + 1];
        }
        size--;
        return remove;
    }

    //Takes out the first element in the list, does NOT remove it
    @Override
    public int peek() throws IndexOutOfBoundsException {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("peek() -- Cant get value when the stacksize is zero");
        }
        return values[0];
    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }

}
