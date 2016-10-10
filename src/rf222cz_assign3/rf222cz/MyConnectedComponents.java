package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.ConnectedComponents;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    private Collection<Collection<Node<E>>> returnCollection;
    private Set<Node<E>> visited;
    private Set<Node<E>> connections;


    /** Code done from pseudo-code from lecture
     * For every node in graph check if the node is already visited
     * For the nodes that is not yet visited get its connections(method above)
     * Check if the nodes connections has a node in common in every node-connection in the returnCollection
     *      If so, merge the two collections together
     * If the connections isn't empty add it to the returnCollection**/
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        //new sets because "Caching of results is forbidden!"
        returnCollection = new HashSet<Collection<Node<E>>>();
        visited = new HashSet<Node<E>>();
        //connections = new HashSet<Node<E>>();//One specific nodes connections

        for (Iterator<Node<E>> it = dg.iterator(); it.hasNext();){
            Node<E> node = it.next();
            if (!visited.contains(node)) {
                connections = new HashSet<Node<E>>(new MyDFS().dfs(dg, node));
                visited.addAll(connections);
            }


            for (Iterator<Collection<Node<E>>> itC = returnCollection.iterator(); itC.hasNext();){
                Collection<Node<E>> nodesInColl = itC.next();

                //Element in common
                if(!Collections.disjoint(nodesInColl, connections)){
                    nodesInColl.addAll(connections);
                    connections = new HashSet<Node<E>>();
                }
            }

            if(!connections.isEmpty()){
                returnCollection.add(connections);
                connections = new HashSet<Node<E>>();
            }

        }
        return returnCollection;
    }
}
