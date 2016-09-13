package rf222cz_assign1.Queue;

/**
 * Created by ymafr on 2016-09-10.
 */
public class QueueMain {
    public static void main(String[] args){
        Queue q = new Queue();

        System.out.println("Is the queue empty? "+q.isEmpty()+"\n");

        System.out.println("--Adding 3 elements--");
        q.enqueue(1);
        q.enqueue("two");
        q.enqueue("three");
        q.enqueue("four");

        System.out.println("Size: "+q.size());
        System.out.println("Is the queue empty? "+q.isEmpty()+"\n");

        System.out.println("--Removing object '"+q.dequeue()+"'--");
        System.out.println("Size: "+q.size()+"\n");

        System.out.println("--The head is now '"+q.first()+"'--\n");
        System.out.println("--The tail is '"+q.last()+"'--\n");

        System.out.println("--Contains '1' - "+q.contains(1)+" --\n");
        System.out.println("--Contains 'two' - "+q.contains("two")+" --\n");
        System.out.println("--Contains 'three' - "+q.contains("three")+" --\n");
        System.out.println("--Contains 'four' - "+q.contains("four")+" --\n");
    }
}
