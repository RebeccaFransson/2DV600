package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyNode<E> extends Node<E>{

    private Set<Node<E>> preds = new HashSet<>();
    private Set<Node<E>> succs = new HashSet<>();

    //Starts the constructor from the abstract class Node<E>
    public MyNode(E item){
        super(item);
    }

    @Override
    public E item() {
        return super.item();
    }

    @Override
    public String toString() {
        return super.toString();
    }


    //Checks if the node in the the successor-set
    @Override
    public boolean hasSucc(Node<E> node) {
        return succs.contains(node);
    }

    @Override
    public int outDegree() {
        return succs.size();
    }

    @Override
    public Iterator<Node<E>> succsOf() {
        return succs.iterator();
    }

    @Override
    public boolean hasPred(Node<E> node) {
        return preds.contains(node);
    }

    @Override
    public int inDegree() {
        return preds.size();
    }

    @Override
    public Iterator<Node<E>> predsOf() {
        return preds.iterator();
    }

    @Override
    public boolean hasReflexiveEdges() {
        return super.hasReflexiveEdges();
    }

    @Override
    public void removeReflexiveEdges() {
        super.removeReflexiveEdges();
    }

    @Override
    public boolean isHead() {
        return super.isHead();
    }

    @Override
    public boolean isTail() {
        return super.isTail();
    }

    @Override
    protected void addSucc(Node<E> succ) {
        succs.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ) {
        succs.remove(succ);
    }

    @Override
    protected void addPred(Node<E> pred) {
        preds.add(pred);
    }

    @Override
    protected void removePred(Node<E> pred) {
        //if(preds.size() == 1)
        //    preds.clear();
        preds.remove(pred);
    }

    @Override
    protected void disconnect() {
        succs.clear();
        preds.clear();
    }
}
