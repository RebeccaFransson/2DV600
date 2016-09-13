package rf222cz_assign2.Exercide2_Ferry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Ferry implements FerryInterface {

    private ArrayList<Passenger> passengers;
    private ArrayList<Vehicle> vehicles;

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
        return vehicles.size();
    }

    @Override
    public int countMoney() {
        return 0;
    }

    @Override
    public void embark(Vehicle v) {
        vehicles.add(v);
        for (Passenger p: v.getPassengers()) {
            embark(p);
        }
    }

    @Override
    public void embark(Passenger p) {
        passengers.add(p);
    }

    @Override
    public void disembark() {

    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        return false;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return false;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return null;
    }
}
