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
        if(item == null)
            throw new NullPointerException("Input for new node was null, in addNodeFor");

        //Check if the graph contains the item
        Node<E> node = graph.get(item);

        //Create new node if not in the Map
        if(node == null){
            node = new MyNode<E>(item);
            //Adds the node to both heads and tails set because it does'nt have eny edges yet
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
        if(from == null || to == null)
            throw new NullPointerException("Input for new edge was null, in addEdgeFor");

        MyNode<E> src = (MyNode<E>) addNodeFor(from);
        MyNode<E> target = (MyNode<E>) addNodeFor(to);
        if (src.hasSucc(target))//Edge is already added
            return false;
        else{
            src.addSucc(target);
            target.addPred(src);
            //Now that the nodes have a edges, remove of from the heads and tails set
            tails.remove(src);
            heads.remove(target);
        }
        return true;
    }

    @Override
    public boolean containsNodeFor(E item) {
        if(item == null)
            throw new NullPointerException("Input for contains node was null, in containsNodeFor");

        return graph.containsKey(item);
    }

    @Override
    public int nodeCount() {
        return graph.size();
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return graph.values().iterator();
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
        return new ArrayList<>(graph.keySet());
    }

    @Override
    public int edgeCount() {
        //Foreach node count outgoing edges
        int count = 0;
        for (Node<E> node : graph.values()) {
            count += node.outDegree();
        }
        return count;
    }

    @Override
    public void removeNodeFor(E item) {
        MyNode<E> removeNode = (MyNode<E>) graph.get(item);

        if(!containsNodeFor(item))
            throw new NullPointerException("Node does not exist in graph, in removeNodeFor");

        //Removes the item from the graph list
        graph.remove(item);

        //Remove the edges associated with item
        for (Iterator<Node<E>> iterator = removeNode.predsOf(); iterator.hasNext();){
            MyNode<E> nextNode = (MyNode<E>) iterator.next();
            nextNode.removePred(removeNode);
            if (nextNode.isHead())
                heads.add(nextNode);
            iterator.remove();
        }
        for (Iterator<Node<E>> iterator = removeNode.succsOf(); iterator.hasNext();){
            MyNode<E> nextNode = (MyNode<E>) iterator.next();
            nextNode.removeSucc(removeNode);
            if (nextNode.isTail())
                tails.add(nextNode);
            iterator.remove();
        }

        tails.remove(removeNode);
        heads.remove(removeNode);
        graph.remove(item);
        removeNode.disconnect();
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        if(from == null || to == null)
            throw new NullPointerException("Input for contains edge was null, in containsEdgeFor");

        MyNode<E> src = (MyNode<E>) getNodeFor(from);
        MyNode<E> target = (MyNode<E>) getNodeFor(to);

        //Check if there is nodes for the input
        if(src == null || target == null)
            return false;

        return src.hasSucc(target) && target.hasPred(src);
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        if(from == null || to == null)
            throw new NullPointerException("Input for remove edge was null, in removeEdgeFor");

        MyNode<E> src = (MyNode<E>) getNodeFor(from);
        MyNode<E> target = (MyNode<E>) getNodeFor(to);

        if(src == null || target == null)
            return false;

        

        return false;
    }
}
