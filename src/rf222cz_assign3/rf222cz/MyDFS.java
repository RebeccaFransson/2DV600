package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DFS;
import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyDFS<E> implements DFS<E> {

    private Set<Node<E>> visited = new HashSet<Node<E>>();
    private List<Node<E>> collection = new ArrayList();
    private List<Node<E>> returnList = new ArrayList();
    private int counterNumber = 0;


    /**Puts the visited node in visited
     * and the visited nodes successors in collection**/
    private void dfs_non_recrusive(Node node){
        /**Non recursive
         * This one is easier to udnerstand, but a bit slower and much more code
         * Change return in dfs to visited instead of collection
         * and change visited to a arrayList above
         * Its only dfs that is non-recursive, not hte other methods in the class**/
        //17ms in test
        collection.add(0, node);
        visited.add(node);
        while (!collection.isEmpty()) {
            Node<E> current = collection.remove(0);
            current.num = counterNumber++;
            returnList.add(current);
            //Check if the node is already visited, if not add it and give it a num

            //Check for successors
            for (Iterator<Node<E>> iterator = current.succsOf(); iterator.hasNext();){
                Node<E> succ = iterator.next();
                if(!visited.contains(succ)) {
                    collection.add(0, succ);
                    visited.add(succ);
                }
            }
        }
    }
    /**Other, faster in contains-method, solution.**/
    private void dfs_recrusive(Node node){
        //15ms in test
        node.num = counterNumber++;
        visited.add(node);
        returnList.add(node);
        //Put the edges to collection
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                dfs_recrusive(succ);//calls itself again
        }
    }

    private void reset(){
        visited.clear();
        collection.clear();
        returnList.clear();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (root == null)
            throw new NullPointerException("The node that will be the root is not given in the depth-first search");
        reset();
        dfs_non_recrusive(root);
        //dfs_recrusive(root);
        return returnList; //For the non-recursive solution
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        if (graph == null)
            throw new NullPointerException("The graph is not given in the depth-first search");
        reset();
        for (Node node : graph)
            if(!visited.contains(node)) dfs_non_recrusive(node);
            //if(!visited.contains(node)) dfs_recrusive(node);
        return returnList; //For the non-recursive solution
    }

/**  ---POST ORDER----  **/
    private void postOrder(Node node){
        visited.add(node);//Visited is only for the fast contains with hashset
        for (Iterator<Node<E>> iterator = node.succsOf(); iterator.hasNext();){
            Node<E> succ = iterator.next();
            if(!visited.contains(succ))
                postOrder(succ);//calls itself again
        }
        node.num = counterNumber++;
        collection.add(node);//This one will be returned.
    }



    //POostOrder with star node
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        reset();
        postOrder(root);
        return collection;
    }

    //Postorder over the whole graph
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        reset();
        for (Iterator<Node<E>> iterator = g.iterator(); iterator.hasNext();){
            Node<E> node = iterator.next();
            if (!visited.contains(node))
                postOrder(node);
        }
        return collection;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        //Check all edges if their nodes has edge to the first node
        //Graph contains backward edges ⇒ graph is cyclic
        //for (Iterator<Node<E>> itG= graph.iterator(); itG.hasNext();){
        for (Node node : postOrder(graph)){
            //Node<E> node = itG.next();
            for (Iterator<Node<E>> itN = node.succsOf(); itN.hasNext();){
                Node<E> succ = itN.next();
                //if(succ.hasSucc(node)) return true; //Checks if the edge between two nodes go back an forth
                //both work, try yourself
                if (node.num <= succ.num) return true; //Checks for backwards edges
            }
        }
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        if (isCyclic(graph)) return null;
        /*List<Node<E>> invertedList = postOrder(graph);
        return Collections.reverse(invertedList);*/

        List<Node<E>> myList = postOrder(graph);
        List<Node<E>> invertedList = new ArrayList();
        for (int i = myList.size() - 1; i >= 0; i--) {
            invertedList.add(myList.get(i));
        }
        return invertedList;
    }
}