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

    /**
     * For every node, make a new list get the reachable nodes from one node
     * add the map with the node and its "reachables"
     *
     * If i re-use the DFS the test takes about 40-50 seconds
     * **/
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        map.clear();

        for (Iterator<Node<E>> iterator = dg.iterator(); iterator.hasNext();){
            Node<E> node = iterator.next();
            map.put(node, new MyDFS().dfs(dg, node));
        }
        return map;
    }
}
