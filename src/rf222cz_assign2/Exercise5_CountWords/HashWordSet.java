package rf222cz_assign2.Exercise5_CountWords;

import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-16.
 */
public class HashWordSet implements WordSet {

    private int size;
    private Node[] buckets;
    private int current;

    public HashWordSet(int bucketsLength) {
        this.buckets = new Node[bucketsLength];
        this.size = 0;
    }

    @Override
    // Add word if not already added
    public void add(Word word) {
        if (!contains(word)) {

            //Get the hashValue to get which bucket
            int position = getBucketNumber(word);

            //Create new node for the new word
            Node newNode = new Node(word);
            newNode.next = this.buckets[position];

            //Add word to set on given position
            this.buckets[position] = newNode;
            //current = position;
            this.size++;
            if(this.size == this.buckets.length)
                rehash();
        }
    }

    @Override
    // Return true if word contained
    public boolean contains(Word word) {
        //Get the hashValue to get which bucket
        int position = getBucketNumber(word);

        Node currentNode = this.buckets[position];
        while (currentNode != null){
            //String nodeString = currentNode.getWord().toString();
            if(currentNode.value.equals(word.toString()))
                return true;
            else
                currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    // Return current set size
    public int size() {
        return this.size;
    }

    //@Override
    // Print contained words
    public String toString(){
        String ret = "[";
        Iterator<Word> itr = iterator();
        while (itr.hasNext()){
            ret += " '"+itr.next().toString()+"' ";
        }
        return ret+"]";
    }

    private int getBucketNumber(Word w) {
        int hashCode = w.hashCode();
        if (hashCode < 0)
            hashCode = -hashCode;

        return hashCode % this.buckets.length;
    }

    //Code from lecture
    private void rehash() {
        Node[] temp = buckets; // Reference to old buckets
        this.buckets = new Node[2*temp.length]; // New empty buckets
        this.size = 0;
        for (Node n : temp) { // Insert old values into new buckets
            if (n == null) continue; // Empty bucket
            while (n != null) {
                add(n.value); // Add elements again
                n = n.next;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new HashIterator();
    }

    //Private Iterator class
    //Code from lecture examples
    private class HashIterator implements Iterator<Word>{
        private int pos = 0;
        private Word[] words;

        public HashIterator() {

            words = new Word[size];
            int n = 0;
            //Creates new array with the words
            for (int i = 0; i < buckets.length; i++) {

                Node node = buckets[i];

                while (node != null) {
                    words[n++] = node.getWord();
                    node = node.next;
                }
            }
        }

        public boolean hasNext() {
            return pos < words.length;
        }

        public Word next() {
            return words[pos++];
        }
        /*private Node currentNode;

        //constructor
        public HashIterator(){
            currentNode = buckets[current];
        }

        public Word next() {
            if (size == 0)
                throw new NullPointerException("Cant get iterators next object when no objects exists.");

            Node ret = currentNode;
            currentNode = currentNode.getNext();
            return ret.getWord();
        }

        public boolean hasNext() {
            if (size == 0)
                throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");

            return currentNode != null;
        }*/
    }

    //Private inner linked list class
    private class Node{
        //Create a new node class
        public Node next = null;
        private Word value;

        public Node(Word obj){
            this.value = obj;
        }

        public Word getWord(){
            return this.value;
        }

        /*public Node getNext(){
            return this.next;
        }*/
    }
}
