package rf222cz_assign3.rf222cz;

import rf222cz_assign3.graphs.DirectedGraph;
import rf222cz_assign3.graphs.GML;

/**
 * Created by ymafr on 2016-09-29.
 */
public class MyGML<E> extends GML<E> {

    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        return null;
    }
}
