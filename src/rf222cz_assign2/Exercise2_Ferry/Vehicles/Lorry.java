package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Lorry extends Vehicle {

    public Lorry(int space, int passengers){
        //cost = 300, passengerCost = 15, maxpassengers = 2
        super(space, 300, passengers, 15, 2);
    }
    @Override
    public String toString() {
        return "--Lorry-- cost: "+this.cost+":-, cost/passenger: "+this.passengerCost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
