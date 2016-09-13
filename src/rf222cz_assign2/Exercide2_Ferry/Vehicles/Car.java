package rf222cz_assign2.Exercide2_Ferry.Vehicles;

import rf222cz_assign2.Exercide2_Ferry.Vehicle;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Car extends Vehicle {

    public Car(int s, int c, int p, int pc, int mp){
        //Kolla så passengers är mindre än maxpassengers
        space = s;
        cost = c;
        passengers = p;
        passengerCost = pc;
        maxPassengers = mp;
    }
}
