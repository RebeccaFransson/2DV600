package rf222cz_assign2.Exercise2_Ferry;

import rf222cz_assign1.Queue.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Ferry implements FerryInterface {

    //Creates all the different spaces so that its easy to change
    protected int bicycleSpace = 1;
    protected int carSpace = bicycleSpace*5;
    protected int busSpace = carSpace*4;
    protected int lorrySpace = busSpace*2;

    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehicles;
    private int vehicleSpace = 0;
    private int maxFerrySpace = carSpace * 40;
    private int money = 0;
    private int maxPassengerRoom = 200;

    public Ferry(){
        //Creates new lists with passengers ans vehicles
        passengers = new ArrayList<Passenger>();
        vehicles = new ArrayList<Vehicle>();
    }
    private int remainingSpace(){return (maxFerrySpace - vehicleSpace)/carSpace; }

    @Override
    //Retuns the nr of passengers onborad
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    //returns the used space on the ferry. Bicycle = 1 space and car = 5 spaces
    public int countVehicleSpace() {
        return vehicleSpace;
    }

    @Override
    //Returns the earned money
    public int countMoney() {
        return money;
    }

    @Override
    //Adds a new vehicle to the list
    public void embark(Vehicle v) {
        //Check if there is enough space on ferry or the vehicle is already on the ferry
        if(!hasSpaceFor(v)) {
            System.err.println("Cant embark vehicle because of lack of space or room for the passengers, or the vehicle is already on the ferry");
        }else if(v.passengers > v.maxPassengers){
            System.err.println("Number of passengers cant be more than "+v.maxPassengers);
        }else{
            money += v.cost;
            vehicleSpace += v.space;
            vehicles.add(v);
            for (Passenger p: v.getPassengers()) {
                embark(p);
            }
        }

    }

    @Override
    //Adds new passenger to the list
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
    //Clearing the Ferry
    public void disembark() {
        vehicles.clear();
        passengers.clear();
        vehicleSpace = 0;
    }

    @Override
    //Check if there is space of the vehicle, and room for its passengers ans if the vehicle is already onbord
    public boolean hasSpaceFor(Vehicle v) {
        return countVehicleSpace() + v.space <= maxFerrySpace && !vehicles.contains(v) && countPassengers() + v.passengers <= maxPassengerRoom;
    }

    @Override
    //Check if there is space of the vehicle, and room for its passengers ans if the vehicle is already onbord
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

    @Override
    //Writes out information about the ferry and is vehicles and passengers.
    //Remove comment to get more information
    public String toString() {
        String ret = "Money: "+countMoney()+"\nCar-space occupied: "+vehicleSpace/carSpace+"\nRemaining car-space: "+remainingSpace()+"\nPassengers: "+countPassengers()+"\n";
        Iterator<Vehicle> itr = iterator();
        while(itr.hasNext()) {
            ret += "["+itr.next().toString();
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
