package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.Node;

import java.util.*;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyGraph<E> implements DirectedGraph<E>{

    private Map<E, Node<E>> graph;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    public MyGraph(){
        graph = new LinkedHashMap<>();
        heads = new HashSet<>();
        tails = new HashSet<>();
    }
    @Override
    public Node<E> addNodeFor(E item) {
        //Check if the graph contains the item
        Node<E> node = graph.get(item);

        //Create new node if not in the Map
        if(node == null){
            node = new MyNode<E>(item);
            heads.add(node);
            tails.add(node);
            graph.put(item, node);
        }
        return node;
    }

    @Override
    public Node<E> getNodeFor(E item) {
        return graph.get(item);
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        return false;
    }

    @Override
    public boolean containsNodeFor(E item) {
        return false;
    }

    @Override
    public int nodeCount() {
        return graph.size();
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return null;
    }

    @Override
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    @Override
    public int headCount() {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    @Override
    public int tailCount() {
        return tails.size();
    }

    @Override
    public List<E> allItems() {
        return null;
    }

    @Override
    public int edgeCount() {
        return 0;
    }

    @Override
    public void removeNodeFor(E item) {

    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        return false;
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        return false;
    }
}
