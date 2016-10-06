package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.BFS;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyBFS<E> implements BFS<E> {

    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private List<Node<E>> collection = new ArrayList();
    private List<Node<E>> returnList = new ArrayList();
    private int counterNumber = 0;

    /**None recursive solution**/
    private void bfs_non_recursive(Node node){
        visited.add(node);
        collection.add(node);

        while (!collection.isEmpty()) {
            Node<E> current = collection.remove(0);
            //Check if the node is already visited, if not add it and give it a num
            current.num = counterNumber++;
            returnList.add(current);
            //Check for successors
            for (Iterator<Node<E>> iterator = current.succsOf(); iterator.hasNext();){
                Node<E> succ = iterator.next();
                if(!visited.contains(succ)){
                    collection.add(succ);
                    visited.add(succ);
                }
            }
        }
    }

    private void reset(){
        visited.clear();
        collection.clear();
        returnList.clear();
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        if (root == null)
            throw new NullPointerException("The node that will be the root is not given in the breadth-first search");
        reset();
        bfs_non_recursive(root);
        return returnList;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        if (graph == null)
            throw new NullPointerException("The graph is not given in the breadth-first search");
        reset();
        for (Node node : graph)
            if(!visited.contains(node)) bfs_non_recursive(node);

        return returnList;
    }
}
