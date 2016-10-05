package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.BFS;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyBFS<E> implements BFS<E> {

    private List<Node<E>> visited = new ArrayList();
    private List<Node<E>> collection = new ArrayList();
    private int depthFirstNumber = 0;

    private void dfs(Node node){
        collection.add(node);

        while (!collection.isEmpty()) {
            Node<E> current = collection.remove(0);
            //Check if the node is already visited, if not add it and give it a num
            if(!visited.contains(current)){
                current.num = depthFirstNumber++;
                visited.add(current);
            }
            //Check for successors
            for (Iterator<Node<E>> iterator = current.succsOf(); iterator.hasNext();){
                Node<E> succ = iterator.next();
                if(!visited.contains(succ) || collection.contains(succ))
                    collection.add(succ);
            }
        }

    }
    private void reset(){
        visited.clear();
        collection.clear();
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        if (root == null)
            throw new NullPointerException("The node that will be the root is not given in the breadth-first search");
        reset();
        dfs(root);
        return visited;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        if (graph == null)
            throw new NullPointerException("The graph is not given in the breadth-first search");
        reset();
        for (Node node : graph)
            if(!visited.contains(node)) dfs(node);

        return visited;
    }
}
