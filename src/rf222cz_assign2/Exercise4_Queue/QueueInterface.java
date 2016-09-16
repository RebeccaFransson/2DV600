package rf222cz_assign2.Exercise4_Queue;

/**
 * Created by ymafr on 2016-09-16.
 */
public interface QueueInterface<E> extends Iterable<E> {
    int size();                          // current queue size
    boolean isEmpty();                   // true if queue is empty
    void enqueue(E element);             // add element at end of queue
    E dequeue();                         // return and remove first element.
    E first();                           // return (without removing) first element
    E last();                            // return (without removing) last element
}
