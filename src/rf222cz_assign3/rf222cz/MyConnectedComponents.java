package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.ConnectedComponents;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private Collection<Collection<Node<E>>> collection;
    private Set<Node<E>> visited;
    private Set<Node<E>> connections;
    private int count = 0;

    private void connected(Node<E> node){
        //kolla om node har connection med node2
        node.num = count++;
        visited.add(node);
        connections.add(node);

        //Reach again if not visited
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!connections.contains(succ))
                connected(succ);
        }

    }

    /**
     * Create new sets
     * for every node in graph - check if its not visited=**/
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        collection = new HashSet<Collection<Node<E>>>();
        connections = new HashSet<Node<E>>();
        visited = new HashSet<Node<E>>();

        for (Iterator<Node<E>> it = dg.iterator(); it.hasNext();){
            Node<E> node = it.next();
            if (!visited.contains(node))
                connected(node);

            for (Iterator<Collection<Node<E>>> itC = collection.iterator(); itC.hasNext();){
                Collection<Node<E>> nodesInColl = itC.next();

                //Element incommon
                if(!Collections.disjoint(nodesInColl, connections)){
                    nodesInColl.addAll(connections);
                    connections = new HashSet<Node<E>>();
                }
            }
            if(!connections.isEmpty()){
                collection.add(connections);
                connections = new HashSet<Node<E>>();
            }

        }
        return collection;
    }
}
