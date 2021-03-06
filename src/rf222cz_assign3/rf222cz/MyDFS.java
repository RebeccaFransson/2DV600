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
    private Set<Node<E>> collectionContains = new HashSet<Node<E>>();
    private List<Node<E>> returnList = new ArrayList();
    private int counterNumber = 0;


    /**Puts the visited node in visited
     * and the visited nodes successors in collection**/
    private void dfs_non_recrusive(Node node){
        /**Non recursive
         * This one is easier to understand, but much more code**/

        collection.add(0, node);
        collectionContains.add(node);
        visited.add(node);
        while (!collection.isEmpty()) {
            Node<E> current = collection.remove(0);
            collectionContains.remove(current);
            current.num = counterNumber++;
            returnList.add(current);
            //Check if the node is already visited, if not add it and give it a num

            //Check for successors
            for (Iterator<Node<E>> iterator = current.succsOf(); iterator.hasNext();){
                Node<E> succ = iterator.next();
                if(!visited.contains(succ) && !collectionContains.contains(succ)) {
                    collection.add(0, succ);
                    collectionContains.add(succ);
                    visited.add(succ);
                }
            }
        }
    }

    /**Recrusive solution.**/
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
        collectionContains.clear();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        if (root == null)
            throw new NullPointerException("The node that will be the root is not given in the depth-first search");
        reset();
        dfs_non_recrusive(root);
        //dfs_recrusive(root); //try the recrusive method
        return returnList;
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        if (graph == null)
            throw new NullPointerException("The graph is not given in the depth-first search");
        reset();

        //Check if there is heads to start with
        if (graph.headCount() != 0) {//If no heads, just take one
            for (Iterator<Node<E>> iterator = graph.heads(); iterator.hasNext();){
                Node<E> head = iterator.next();
                if(!visited.contains(head)) dfs_non_recrusive(head);
                //if(!visited.contains(head)) dfs_recrusive(head); //try the recrusive method
            }
        }else{
            dfs_non_recrusive(graph.getNodeFor(graph.allItems().get(0)));
            //dfs_recrusive(graph.getNodeFor(graph.allItems().get(0))); //try the recrusive method
        }
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
        returnList.add(node);
    }



    //PostOrder with start node
    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        reset();
        postOrder(root);
        return returnList;
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
        return returnList;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        //Check all edges if their nodes has edge to the first node
        //Graph contains backward edges ⇒ graph is cyclic
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

        List<Node<E>> myList = postOrder(graph);
        List<Node<E>> invertedList = new ArrayList();
        for (int i = myList.size() - 1; i >= 0; i--) {
            invertedList.add(myList.get(i));
        }
        return invertedList;
    }
}