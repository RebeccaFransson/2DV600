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
        string.append("graph [");
                        //"\tHeads: "+graph.headCount()+
                        //"\n\tTails: "+graph.tailCount()+"\n");
        for (Iterator<Node<E>> iterator = graph.iterator(); iterator.hasNext();){
            MyNode<E> node = (MyNode<E>) iterator.next();
            string.append("\n\tnode [\n \t\tid "+node.item()+
                            "\n \t\tlabel \"node nr "+node.item()+"\"\n\t]");
                            //"'\n \t\tOutDegree: "+node.outDegree()+
                            //"\n \t\tInDegree: "+node.inDegree()+
                            //"\n \t\tIsTail: "+node.isTail()+
                            //"\n \t\tIsHead: "+node.isHead()+
                            //"\n \t\tHasReflexiveEdges: "+node.hasReflexiveEdges());
        }

        for (Node<E> node : graph){
            for (Iterator<Node<E>> itS = node.succsOf(); itS.hasNext(); ) {
                MyNode<E> next = (MyNode<E>) itS.next();
                string.append("\n\tedge [");
                string.append("\n\t\tsource " + node +
                        "\n\t\ttarget " + next+
                        "\n\t\tlabel \"node "+ node+"\"");
                string.append("\n\t]");
            }
        }

        return string.toString();
    }

    public static void main(){

    }
}
