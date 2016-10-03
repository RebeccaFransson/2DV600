package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.GML;
import rf222cz_assign3.graphs.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        StringBuilder string = new StringBuilder();
        string.append("Graph [ \n"+
                        "\tHeads: "+graph.headCount()+
                        "\n\tTails: "+graph.tailCount()+"\n\t");
        for (Iterator<Node<E>> iterator = graph.iterator(); iterator.hasNext();){
            MyNode<E> node = (MyNode<E>) iterator.next();
            string.append("node [\n \t\tItem: "+node.item()+
                            "\n \t\tOutDegree: "+node.outDegree()+
                            "\n \t\tInDegree: "+node.inDegree()+
                            "\n \t\tIsTail: "+node.isTail()+
                            "\n \t\tIsHead: "+node.isHead()+
                            "\n \t\tHasReflexiveEdges: "+node.hasReflexiveEdges());

            string.append("\n \t\tSuccessor [");
            for (Iterator<Node<E>> itS = node.succsOf(); itS.hasNext();){
                MyNode<E> succ = (MyNode<E>) itS.next();
                string.append("\n\t\t\tItem: "+succ.item());
            }
            string.append("]Predecessors [");
            for (Iterator<Node<E>> itP = node.predsOf(); itP.hasNext();){
                MyNode<E> pred = (MyNode<E>) itP.next();
                string.append("\n\t\t\tItem: "+pred.item());
            }
            string.append("\n\t]");
        }

        return string.toString();
    }

    public static void main(){

    }
}
