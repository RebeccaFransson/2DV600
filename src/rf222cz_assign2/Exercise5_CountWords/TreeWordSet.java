package rf222cz_assign2.Exercise5_CountWords;

import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-19.
 */
public class TreeWordSet implements WordSet {

    private BST root = null;
    private int size;

    public TreeWordSet(){
        this.size = 0;
    }

    @Override
    public void add(Word w) {
        if(!contains(w)){
            if (root==null){
                root = new BST(w);
            }else{
                root.add(w);
                this.size++;
            }
        }
    }

    @Override
    public boolean contains(Word w) {
        if (root==null)
            return false;
        else
            return root.contains(w);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String ret = "[";
        Iterator<Word> itr = iterator();
        while (itr.hasNext()){
            ret += " '"+itr.next().toString()+"' ";
        }
        return ret+"]";
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator();
    }

    //Private Iterator class
    private class TreeIterator implements Iterator<Word>{
        private BST next;

        //constructor
        public TreeIterator(){
            next = root;

            //no elements.
            if(next == null) {
                return;
            }

            //the node furthest to the left
            while (next.left != null) {
                next = next.left;
            }
        }

        public Word next() {
            if (size <= 0)
                throw new NullPointerException("Cant get iterators next object when no objects exists.");
            return new Word("hej");
        }

        public boolean hasNext() {
            if (size <= 0)
                throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");
            return false;
        }
    }

    //Code from lecture slides
    private class BST { // private inner class
        Word value;
        private BST left = null;
        private BST right = null;

        public BST(Word val) { value = val;}

        public void add(Word w) {// recursive add
            //value comes before w
            if (value.compareTo(w) > 0) { // add to left branch
                if ( left == null)
                    left = new BST(w);
                else
                    left .add(w);
            }
            //w comes before value
            else if (value.compareTo(w) < 0) { // add to right branch
                if ( right == null)
                    right = new BST(w);
                else
                    right .add(w);
            }

        }

        public boolean contains(Word w) { // recursive look−up
            if (value.compareTo(w) > 0) { // search left branch
                if (left == null)
                    return false;
                else
                    return left.contains(w);
            }
            else if (value.compareTo(w) > 0) { // search right branch
                if (right == null)
                    return false;
                else
                    return right.contains(w);
            }
            return true; // Found!
        }
    }

}
