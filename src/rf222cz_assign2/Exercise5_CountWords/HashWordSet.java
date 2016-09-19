/*package rf222cz_assign2.Exercise5_CountWords;

import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-16.
 */
/*public class HashWordSet implements WordSet {

    private int size = 0;
    private Node[] buckets = new Node[8];

    @Override
    public void add(Word word) {

    }

    @Override
    public boolean contains(Word word) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString(){
        return "";
    }

    public Iterator iterator() {
        return new Iterator() {
            //private Node h = head;

            public Object next() {
                //if (isEmpty())
                //    throw new NullPointerException("Cant get iterators next object when no objects exists.");

                Node ret = h;
                h = h.getNext();
                return ret.getValue();
            }

            public boolean hasNext() {
                //if (isEmpty())
                //    throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");
                return h != null;
            }
        };
    }

    //Private node class
    private class Node{
        //Create a new node class
        public Node next = null;
        private Word value;

        public Node(Word obj){
            this.value = obj;
        }

        public Word getValue(){
            return this.value;
        }

        public void setNext(Node obj){
            this.next = obj;
        }

        public Node getNext(){
            return this.next;
        }
    }
}*/
