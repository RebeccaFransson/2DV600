package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DFS;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyDFS<E> implements DFS<E> {

    private List visited = new ArrayList();
    private List collection = new ArrayList();
    private int depthFirstNumber = 0;


    /**Puts the visited node in visited
     * and the visited nodes successors in collection**/
    private void dfs(Node node){
        node.num = depthFirstNumber++;
        visited.add(node);
        collection.add(node);

        //But the edges to collection
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                dfs(succ);//calls itself again
        }

    }
    private void reset(){
        visited.clear();
        collection.clear();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        reset();
        dfs(root);
        return collection;
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        reset();

        for (Node node : graph)
            if(!visited.contains(node)) dfs(node);

        return collection;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        return null;
    }
}
