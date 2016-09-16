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

        //Sends parameter space and passengers
        Bicycle bicycle = new Bicycle(ferry.bicycleSpace);
        Car car = new Car(ferry.carSpace, 3);
        Bus bus = new Bus(ferry.busSpace, 19);
        Lorry lorry = new Lorry(ferry.lorrySpace, 1);
        Passenger linda = new Passenger(20);


        ferry.embark(linda);
        ferry.embark(car);
        ferry.embark(bicycle);
        ferry.embark(bus);
        ferry.embark(lorry);



        System.out.println("---Emarking---");
        System.out.println(ferry.toString());


        ferry.disembark();
        System.out.println("---Disembarking---");
        System.out.println(ferry.toString());


        //Max number of space and room for passengers
        for (int i = 0; i < 39; i++){
            ferry.embark(new Car(ferry.carSpace, 4));
        }
        for (int i = 0; i < 5; i++){
            ferry.embark(new Bicycle(ferry.bicycleSpace));
        }
        ferry.embark(new Bicycle(ferry.bicycleSpace));//Couldnt go, lack of space

        System.out.println("---Emarking second time---");
        System.out.println(ferry.toString());
    }
}
