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
        Bicycle bicycle = new Bicycle(ferry.BICYKLE_SPACE);
        Car car = new Car(ferry.CAR_SPACE, 3);
        Bus bus = new Bus(ferry.BUS_SPACE, 19);
        Lorry lorry = new Lorry(ferry.LORRY_SPACE, 1);
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
            ferry.embark(new Car(ferry.CAR_SPACE, 4));
        }
        for (int i = 0; i < 5; i++){
            ferry.embark(new Bicycle(ferry.BICYKLE_SPACE));
        }
        ferry.embark(new Bicycle(ferry.BICYKLE_SPACE));//Couldnt go on, lack of space

        System.out.println("---Emarking second time---");
        System.out.println(ferry.toString());

        ferry.disembark();
        System.out.println("---Disembarking second time---");
        System.out.println(ferry.toString());

    }
}
