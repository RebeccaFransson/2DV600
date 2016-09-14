package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Bicycle extends Vehicle{

    public Bicycle(int space){
        //space = 0, cost = 20, passengerCost = 0, maxpassengers = 1
        super(space, 20, 1, 0, 1);//Calls the constructor in the parent-class - Vehicle
    }

    @Override
    public String toString() {
        return "--Bicycle-- cost: "+this.cost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
