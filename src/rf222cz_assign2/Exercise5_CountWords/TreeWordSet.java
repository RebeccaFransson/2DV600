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

    //Check is the word is already in the set, add it if its not
    //method add is in the BST-class
    @Override
    public void add(Word w) {
        if(!contains(w)){
            if (root==null){
                root = new BST(root, w);
            }else{
                root.add(w);
            }
        }
    }

    //Check if the word is in the set. method contains is in the BST-class
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

    //Returns a string with the words in alphabetical order, array-like : ['word' 'word' 'word' ]
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
            //no elements in set
            if(next == null)
                return;

            //get the node furthest to the left
            while (next.left != null)
                next = next.left;
        }

        public Word next() {
            if (size <= 0)
                throw new NullPointerException("Cant get iterators next word when treeset is empty.");
            BST retW = next;

            if(next.right != null){//Go to the right
                next = next.right;

                //Go to the word furthest left
                while (next.left != null)
                    next = next.left;

                return retW.word;
            }else{
                while (next.parent != null){//As long as next isn't the root
                    if(next.parent.left == next){//go to the left
                        next = next.parent;
                        return retW.word;
                    }
                    next = next.parent;
                }
                next = null;
                return retW.word;
            }

        }

        public boolean hasNext() {
            if (size <= 0)
                throw new NullPointerException("Cant get iterators hasNext word when treeset is empty");
            return next != null;
        }
    }

    //Code from lecture slides
    private class BST { // private inner class
        private Word word;
        private BST left;
        private BST right;
        private BST parent;

        public BST(BST parent, Word val) {
            //Add the size every time new branch is created
            this.parent = parent;
            this.word = val;
            size++;
        }

        public void add(Word w) {// recursive add
            //w comes before word
            if (this.word.compareTo(w) > 0) { // add to left branch
                if (this.left == null)
                    this.left = new BST(this, w);
                else
                    this.left.add(w);
            }
            //word comes before w
            else if (this.word.compareTo(w) < 0) { // add to right branch
                if (this.right == null)
                    this.right = new BST(this, w);
                else
                    this.right.add(w);

            }
            //Found the word in the set- do noting
        }

        public boolean contains(Word w) { // recursive look−up
            if (this.word.compareTo(w) < 0) { // search left branch
                if (this.left == null)
                    return false;
                else
                    return this.left.contains(w);
            }
            else if (this.word.compareTo(w) > 0) { // search right branch
                if (this.right == null)
                    return false;
                else
                    return this.right.contains(w);
            }
            return true; // Found!
        }

    }

}
