package rf222cz_assign2;

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
        if(index > size){
            throw new IndexOutOfBoundsException("addAt() -- Cant add when the index is bigger then the listsize");
        }
        //Create new int[]?
        /*int[] results = new int[values.length];
        //Loop up to the index
        for (int i = 0; i < index; i++){
            results[i] = values[i];
        }
        results[index] = n;
        for (int i = index; i < values.length; i++){
            values[i] = values[i - 1];
        }
        values[] = results[];*/
        for (int i = index; i < values.length; i++){
            values[i] = values[i - 1];
        }
        values[index] = n;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if(index > size){
            throw new IndexOutOfBoundsException("addAt() -- Cant add when the index is bigger then the listsize");
        }

    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        return 0;
    }

    @Override
    public int indexOf(int n) {
        return 0;
    }

    /*@Override
    public String toString() {
        String s = "{";
        for (int nr : values) {
            s += nr+" ";
        }
        return s+"}";
    }*/
}
