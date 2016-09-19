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
                root = new BST(root, w);
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
            BST returnWord = next;

            if(next.right != null){
                next = next.right;

                //Go to the word furthest left
                while (next.left != null){
                    next = next.left;
                }
                return returnWord.value;
            }else{
                while (next.parent != null){
                    if(next.parent.left == next){
                        next = next.parent;
                        return returnWord.value;
                    }
                    next = next.parent;
                }
                next = null;
                return returnWord.value;
            }

        }

        public boolean hasNext() {
            if (size <= 0)
                throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");
            return next != null;
        }
    }

    //Code from lecture slides
    private class BST { // private inner class
        private Word value;
        private BST left;
        private BST right;
        private BST parent;

        public BST(BST parent, Word val) {
            this.parent = parent;
            this.value = val;
        }

        public void add(Word w) {// recursive add
            //value comes before w
            if (this.value.compareTo(w) < 0) { // add to left branch
                if (this.left == null)
                    this.left = new BST(this, w);
                else
                    this.left.add(w);
            }
            //w comes before value
            else if (this.value.compareTo(w) > 0) { // add to right branch
                if (this.right == null)
                    this.right = new BST(this, w);
                else
                    this.right.add(w);
            }

        }

        public boolean contains(Word w) { // recursive look−up
            if (this.value.compareTo(w) > 0) { // search left branch
                if (this.left == null)
                    return false;
                else
                    return this.left.contains(w);
            }
            else if (this.value.compareTo(w) > 0) { // search right branch
                if (this.right == null)
                    return false;
                else
                    return this.right.contains(w);
            }
            return true; // Found!
        }
    }

}
