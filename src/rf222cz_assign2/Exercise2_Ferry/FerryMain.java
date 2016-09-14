package rf222cz_assign2.Exercise2_Ferry;

import rf222cz_assign2.Exercise2_Ferry.Vehicles.Bicycle;
import rf222cz_assign2.Exercise2_Ferry.Vehicles.Bus;
import rf222cz_assign2.Exercise2_Ferry.Vehicles.Car;
import rf222cz_assign2.Exercise2_Ferry.Vehicles.Lorry;

/**
 * Created by ymafr on 2016-09-13.
 */
public class FerryMain {
    public static void main(String[] args) {
        Ferry ferry = new Ferry();

        //Onödigt att skicka med de värderna som alltid är de samma för varje fordon
        //Tillexempel: kostand, passengerCost, maxPassengers, space
        Bicycle bicycle = new Bicycle(ferry.bicycleSpace, 20);
        Car car = new Car(ferry.carSpace, 100, 3, 15, 4);
        Bus bus = new Bus(ferry.busSpace, 200, 19, 10, 20);
        Lorry lorry = new Lorry(ferry.lorrySpace, 300, 1, 15, 2);
        Lorry lorry2 = new Lorry(ferry.lorrySpace, 300, 1, 15, 2);
        Lorry lorry3 = new Lorry(ferry.lorrySpace, 300, 1, 15, 2);
        Lorry lorry4 = new Lorry(ferry.lorrySpace, 300, 1, 15, 2);
        Passenger linda = new Passenger(20);



        ferry.embark(linda);
        ferry.embark(car);
        ferry.embark(bicycle);
        ferry.embark(bus);
        ferry.embark(lorry);

        System.out.println(ferry.toString());

        ferry.embark(lorry2);
        ferry.embark(lorry3);
        ferry.embark(lorry4);

        System.out.println("After more lorrys");
        System.out.println(ferry.toString());

        //System.out.println(ferry.hasRoomFor());
    }
}
