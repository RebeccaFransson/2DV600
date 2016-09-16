package rf222cz_assign2.Exercise4_Queue;

import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-16.
 */
public class Queue implements QueueInterface {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object element) {
        if (head == null) { // Add first element
            head = new Node(element);
            tail = head;
        }
        else {
            tail.next = new Node(element); // Attach new node
            tail = tail.next; // Update tail
        }
        size ++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant remove a object when no objects exists.");
        Node remove = head;
        head = remove.getNext();
        size--;
        return remove.getObject();
    }

    @Override
    public Object first() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant return first object when no objects exists.");
        return head.getObject();
    }

    @Override
    public Object last() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant return last object when no objects exists.");
        return tail.getObject();
    }

    public Iterator iterator() {
        return new Iterator() {
            private Node h = head;

            public Object next() {
                if (isEmpty())
                    throw new NullPointerException("Cant get iterators next object when no objects exists.");

                Node ret = h;
                h = h.getNext();
                return ret.getObject();
            }

            public boolean hasNext() {
                if (isEmpty())
                    throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");
                return h != null;
            }
        };
    }

    //Private node class
    private class Node{
        //Create a new node class
        public Node next = null;
        private Object value;

        public Node(Object obj){
            value = obj;
        }

        public Object getObject(){
            return value;
        }

        public void setNext(Node obj){
            next = obj;
        }

        public Node getNext(){
            return next;
        }
    }
}
