package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Bicycle extends Vehicle{

    public Bicycle(int s, int c){
        super(s, c, 1, 0, 1);
    }
    @Override
    public String toString() {
        return "--Bicycle-- cost: "+this.cost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
