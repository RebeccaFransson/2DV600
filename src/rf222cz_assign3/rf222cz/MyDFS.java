package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DFS;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyDFS<E> implements DFS<E> {

    //private Set<Node<E>> visited = new HashSet<Node<E>>(); //For the recursive solution
    private List<Node<E>> visited = new ArrayList();
    private List<Node<E>> collection = new ArrayList();
    private int depthFirstNumber = 0;


    /**Puts the visited node in visited
     * and the visited nodes successors in collection**/
    private void dfs(Node node){


        //17ms
        collection.add(0, node);
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
                    collection.add(0,succ);
            }
        }

        /**Other, faster in contains-method, solution.
         * Change return in dfs to collection instead of visited
            and change visited to a hashset above**/
        //15ms
        /*node.num = depthFirstNumber++;
        visited.add(node);
        collection.add(node);
        //But the edges to collection
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                dfs(succ);//calls itself again
        }*/

    }
    private void reset(){
        visited.clear();
        collection.clear();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (root == null)
            throw new NullPointerException("The node that will be the root is not given in the depth-first search");
        reset();
        dfs(root);
        return visited;
        //return collection; //For the recursive solution
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        if (graph == null)
            throw new NullPointerException("The graph is not given in the depth-first search");
        reset();
        for (Node node : graph)
            if(!visited.contains(node)) dfs(node);

        return visited;
        //return collection;//For the recursive solution
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
