package rf222cz_assign1.Queue;

import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-10.
 */
public class Queue implements QueueInterface{
    private int size = 0;
    private Node head = null;
    private Node tail = null;


    @Override
    //Returns the size
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override//Code from lecture
    //Adds a new object
    public void enqueue(Object element){
        if (head == null) { // Add first element
            head = new Node(element);
            tail = head;
        }
        else {
            tail.next = new Node(element); // Attach new node
            tail = tail.next; // Update tail

            //Slower way
            /*Node node = head;
            while (node.next != null ) // Find last node
                node = node.next;
            node.next = new Node(element);*/ // Attach new node
        }
        size ++;
    }

    @Override
    //Remove the first object, sets the second object as the first.
    public Object dequeue()throws IndexOutOfBoundsException{
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant remove a object when no objects exists.");
        Node remove = head;
        head = remove.getNext();
        size--;
        return remove.getObject();
    }

    @Override
    //Get the first object
    public Object first()throws IndexOutOfBoundsException{//exeption
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant return first object when no objects exists.");
        return head.getObject();
    }

    @Override
    //Get the last object
    public Object last()throws IndexOutOfBoundsException{
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant return last object when no objects exists.");
        return tail.getObject();
    }

    @Override
    //Check if it contains the object from param
    public boolean contains(Object o){
        if (isEmpty())
            throw new IndexOutOfBoundsException("Cant see if '"+o+"' is among the objects if the objects dont exists.");
        Iterator<Object> itr = iterator();
        while(itr.hasNext()) {
            if(itr.next() == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator(){
        //Creates new iterator object and returning it
        return new Iterator() {
            private Node h = head;

            //Get boolean if there is a next object
            public boolean hasNext() {
                if (isEmpty())
                    throw new NullPointerException("Cant get iterators hasNext object when no objects exists.");
                return h != null;

            }
            //continues counting "list" in next. "after" returning.
            public Object next() {
                if (isEmpty())
                    throw new NullPointerException("Cant get iterators next object when no objects exists.");
                //Gets the next, but returns the one before
                //This needed to be done so that the head and the tail was included in the counting
                Node ret = h;
                h = h.getNext();
                return ret.getObject();
            }
        };
    }

}
