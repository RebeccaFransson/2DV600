package rf222cz_assign2.Exercide2_Ferry;

import java.util.ArrayList;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Vehicle {
    protected int space;
    protected int cost;
    protected int passengers;
    protected int passengerCost;
    protected int maxPassengers;

    public Vehicle(){

    }

    public ArrayList<Passenger> getPassengers(){
        ArrayList<Passenger> passengersInVehicle = new ArrayList<Passenger>(passengers);
        for (int i = 0; i < passengers; i++){
            passengersInVehicle.add(new Passenger(passengerCost));
        }
        return passengersInVehicle;
    }


}
