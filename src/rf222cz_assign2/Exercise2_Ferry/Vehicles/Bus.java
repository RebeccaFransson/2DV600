package rf222cz_assign2.Exercise2_Ferry.Vehicles;

import rf222cz_assign2.Exercise2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Bus extends Vehicle {
    /*protected int space = 20;
    protected int cost = 200;
    protected int passengerCost = 10;
    protected int maxPassengers = 20;*/
    public Bus(int s, int c, int p, int pc, int mp){
        super(s, c, p, pc, mp);
    }
    @Override
    public String toString() {
        return "--Bus-- cost: "+this.cost+":-, cost/passenger: "+this.passengerCost+
                ":-, passengers: "+this.passengers+", space: "+this.space;
    }
}
