package rf222cz_assign2.Exercise2_Ferry;

/**
 * Created by ymafr on 2016-09-13.
 */
public class Passenger {
    protected int cost;

    public Passenger(int passengerCost){
        this.cost = passengerCost;
    }

    @Override
    public String toString() {
        return "\tPassengers cost: "+this.cost+":-";
    }
}
