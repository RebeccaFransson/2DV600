package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.ConnectedComponents;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private Collection<Collection<Node<E>>> collection = new HashSet<Collection<Node<E>>>();
    private Collection<Node<E>> visited;
    private int count = 0;

    private void connected(Node<E> node, Node<E> node2){
        //kolla om node har connection med node2
        node.num = count++;
        visited.add(node);

        //Reach again if not visited
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                connected(succ, succ);
        }

    }

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        collection.clear();
        //foreach node
        for (Iterator<Node<E>> it = dg.iterator(); it.hasNext();){
            for (Iterator<Node<E>> it2 = dg.iterator(); it2.hasNext();){
                visited = new HashSet<Node<E>>();

                Node<E> node = it.next(), node2 = it2.next();
                connected(node,node2);
                collection.add(visited);
            }
        }
        return null;
    }
}
