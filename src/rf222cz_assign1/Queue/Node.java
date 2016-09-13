package rf222cz_assign1.Queue;

/**
 * Created by ymafr on 2016-09-10.
 */
public class Node {
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
