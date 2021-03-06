package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Car extends Vehicle {

    public Car(int space, int passengers){
        //cost = 200, passengerCost = 15, maxpassengers = 20
        super(space, 200, passengers, 15, 20);//Calls the constructor in the parent-class - Vehicle
    }

    @Override
    public String toString() {
        return "--Car-- cost: "+this.cost+":-, cost/passenger: "+this.passengerCost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
