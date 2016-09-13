package rf222cz_assign2.Exercise1_Collection;

import da1031.AbstractIntCollection;

/**
 * Created by ymafr on 2016-09-13.
 */
public class ArrayIntList extends da1031.AbstractIntCollection implements da1031.IntList {

    @Override
    public void add(int n) {
        values[size()] = n;
        size++;
        if(size() >= values.length)
            resize();
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size())){
            throw new IndexOutOfBoundsException("addAt() -- Cant add when the index is bigger then the listsize");
        }
        //Adding the last value to the list
        add(values[size()]);
        //Taking the value of the list and replaces the value from the list with one less index
        for (int i = size(); i > index; i--){
            values[i] = values[i - 1];
        }
        values[index] = n;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size())){
            throw new IndexOutOfBoundsException("remove() -- Cant remove when the index is bigger then the listsize");
        }
        for (int i = index; i < size(); i++){
            values[i] = values[i + 1];
        }
        size--;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size())){
            throw new IndexOutOfBoundsException("get() -- Cant get when the index is bigger then the listsize");
        }
        return values[index];
    }

    @Override
    public int indexOf(int n) {
        int ret = -1;
        for(int i = 0; i < size(); i++){
            if(values[i] == n)
                ret = i;
        }
        return ret;
    }
}
