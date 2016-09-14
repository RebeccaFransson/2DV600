package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Car extends Vehicle {

    public Car(int s, int c, int p, int pc, int mp){
        super(s, c, p, pc, mp);
    }

    @Override
    public String toString() {
        return "--Car-- cost: "+this.cost+":-, cost/passenger: "+this.passengerCost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
