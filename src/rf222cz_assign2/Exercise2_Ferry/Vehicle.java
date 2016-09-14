package rf222cz_assign2.Exercise2_Ferry;

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
    private ArrayList<Passenger> passengersInVehicle;

    public Vehicle(int s, int c, int p, int pc, int mp){
        space = s;
        cost = c;
        passengerCost = pc;
        maxPassengers = mp;
        passengers = p;

        //Creates a new list with passengers for each vehicle
        passengersInVehicle = new ArrayList<>(passengers);
        for (int i = 0; i < passengers; i++){
            passengersInVehicle.add(new Passenger(passengerCost));
        }
    }

    public ArrayList<Passenger> getPassengers(){
        return passengersInVehicle;
    }


}
