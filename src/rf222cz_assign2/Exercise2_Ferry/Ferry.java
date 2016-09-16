package rf222cz_assign2.Exercise2_Ferry;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Ferry implements FerryInterface {

    //Creates all the different spaces Iin one place so that its easy to change
    protected int BICYKLE_SPACE = 1;
    protected int CAR_SPACE = BICYKLE_SPACE *5;
    protected int BUS_SPACE = CAR_SPACE *4;
    protected int LORRY_SPACE = BUS_SPACE *2;

    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehicles;
    private int MAX_CAR_SPACE = CAR_SPACE * 40;
    private int money = 0;
    private int MAX_PASSENGER_ROOM = 200;

    public Ferry(){
        //Creates new lists with passengers ans vehicles
        passengers = new ArrayList<Passenger>();
        vehicles = new ArrayList<Vehicle>();
    }

    @Override
    //Retuns the nr of passengers onborad
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    //returns the used space on the ferry. Bicycle = 1 space and car = 5 spaces
    public int countVehicleSpace() {
        //return vehicleSpace;
        int count = 0;
        for (Vehicle v : vehicles) {
            count += v.space;
        }
        return count;
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
    }

    @Override
    //Check if there is space of the vehicle, and room for its passengers ans if the vehicle is already onbord
    public boolean hasSpaceFor(Vehicle v) {
        return countVehicleSpace() + v.space <= MAX_CAR_SPACE && !vehicles.contains(v) && countPassengers() + v.passengers <= MAX_PASSENGER_ROOM;
    }

    @Override
    //Check if there is space of the vehicle, and room for its passengers ans if the vehicle is already onbord
    public boolean hasRoomFor(Passenger p) {
        return countPassengers() < MAX_PASSENGER_ROOM && !passengers.contains(p);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator() {
            private int count = 0;
            public Vehicle next() {return vehicles.get(count++);}

            public boolean hasNext() {return count<vehicles.size();}
        };
    }

    @Override
    //Writes out information about the ferry and is vehicles and passengers.
    //Remove comment to get more information
    public String toString() {
        if(vehicles.isEmpty()){
            return "The ferry is disembarked, eard money is: "+countMoney();
        }
        String ret = "Money: "+countMoney()+"\nCar-space occupied: "+countVehicleSpace()/ CAR_SPACE +"\nRemaining car-space: "+(MAX_CAR_SPACE - countVehicleSpace())/ CAR_SPACE +"\nPassengers: "+countPassengers()+"\n";
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
