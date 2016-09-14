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
        if(p > maxPassengers){
            System.err.println("Number of passengers cant be more than "+maxPassengers);
        }else{
            passengers = p;
        }

        passengersInVehicle = new ArrayList<>(passengers);
        for (int i = 0; i < passengers; i++){
            passengersInVehicle.add(new Passenger(passengerCost));
        }
    }

    public ArrayList<Passenger> getPassengers(){
        return passengersInVehicle;
    }


}
