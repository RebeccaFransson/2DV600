package rf222cz_assign2.Exercise2_Ferry;

import rf222cz_assign1.Queue.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Ferry implements FerryInterface {

    protected int bicycleSpace = 1;
    protected int carSpace = bicycleSpace*5;
    protected int busSpace = carSpace*4;
    protected int lorrySpace = busSpace*2;

    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehicles;
    private int vehiclespace = 0;
    private int maxFerrySpace = carSpace * 40;
    private int money = 0;
    private int maxPassengerRoom = 200;

    public Ferry(){
        passengers = new ArrayList<Passenger>();
        vehicles = new ArrayList<Vehicle>();
    }

    @Override
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    public int countVehicleSpace() {
        return vehiclespace;
    }

    @Override
    public int countMoney() {
        return money;
    }

    @Override
    public void embark(Vehicle v) {

        //Check if there is enough space on ferry or the vehicle is already on the ferry
        if(!hasSpaceFor(v)) {
            System.err.println("Cant embark vehicle because of lack of space or room for the passengers, or the vehicle is already on the ferry");
        }else if(v.passengers > v.maxPassengers){
            System.err.println("Number of passengers cant be more than "+v.maxPassengers);
        }else{
            money += v.cost;
            vehiclespace += v.space;
            vehicles.add(v);
            for (Passenger p: v.getPassengers()) {
                embark(p);
            }
        }

    }

    @Override
    public void embark(Passenger p) {
        //Check if there is enough space on ferry or the passenger is already on the ferry
        if(!hasRoomFor(p)){
            System.err.println("Cant embark passenger because of lack of room or the passenger is already on the ferry.");
        }else{
            money += p.cost;
            passengers.add(p);
        }
    }

    @Override
    public void disembark() {
        vehicles.clear();
        passengers.clear();
        vehiclespace = 0;
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        //Kolla om det finns plats för alla v passengers
        return countVehicleSpace() + v.space <= maxFerrySpace && !vehicles.contains(v) && countPassengers() + v.passengers <= maxPassengerRoom;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return countPassengers() < maxPassengerRoom && !passengers.contains(p);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator() {
            private int count = 0;
            public Vehicle next() {return vehicles.get(count++);}

            public boolean hasNext() {return count<vehicles.size();}

            public void remove() {
                throw new RuntimeException("remove() is not implemented");
            }
        };
    }

    //Kalla på tostring till varje fordon
    @Override
    public String toString() {
        String ret = "Money: "+countMoney()+"\nSpace: "+vehiclespace+"\nPassengers: "+countPassengers()+"\n";
        for (Vehicle v: vehicles) {
            ret += "["+v.toString();
            /*ret += "\nPassengers: \n";
            for (Passenger p: v.getPassengers()) {
                ret += p.toString()+"\n";
            }*/
            ret += "]\n";
        }
        /*ret += "All passengers: \n";
        for (Passenger p: passengers) {
            ret += p.toString();
        }*/

        return ret;
    }
}
