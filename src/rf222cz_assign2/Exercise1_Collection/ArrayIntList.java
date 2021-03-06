package rf222cz_assign2.Exercise1_Collection;

import rf222cz_assign2.da1031.IntList;

/**
 * Created by ymafr on 2016-09-13.
 */
public class ArrayIntList extends rf222cz_assign2.da1031.AbstractIntCollection implements IntList {

    //Adds a element to the list
    @Override
    public void add(int n) {
        values[size()] = n;
        size++;
        if(size() >= values.length)
            resize();
    }

    //Adds a element on a specific spot in the list
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size()) || isEmpty()){
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

    //Removes the element with the index and moves all the elements a step back
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size()) || isEmpty()){
            throw new IndexOutOfBoundsException("remove() -- Cant remove when the index is bigger then the listsize");
        }
        for (int i = index; i < size(); i++){
            values[i] = values[i + 1];
        }
        size--;
    }

    //Returns the element with specific index
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if(!checkIndex(index, size()) || isEmpty()){
            throw new IndexOutOfBoundsException("get() -- Cant get when the index is bigger then the listsize");
        }
        return values[index];
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    //Get the index of an element
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
