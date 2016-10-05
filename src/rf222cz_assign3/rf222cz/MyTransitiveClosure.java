package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;
import rf222cz_assign3.graphs.TransitiveClosure;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E> {

    private Map<Node<E>, Collection<Node<E>>> map = new LinkedHashMap<Node<E>, Collection<Node<E>>>();
    private Collection<Node<E>> visited;
    private int count = 0;

    private void reachable(Node node){
        node.num = count++;
        visited.add(node);

        //Reach again if not visited
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                 reachable(succ);
        }
    }

    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        map.clear();

        //For evry node, make a new list get the reachable nodes from one node
        //add the map with the node and its "reachables"
        for (Iterator<Node<E>> iterator = dg.iterator(); iterator.hasNext();){
            visited = new HashSet<Node<E>>();
            Node<E> node = iterator.next();
            reachable(node);
            map.put(node, visited);
        }
        return map;
    }
}
