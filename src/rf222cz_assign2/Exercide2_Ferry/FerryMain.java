package rf222cz_assign2.Exercide2_Ferry;

import rf222cz_assign2.Exercide2_Ferry.Vehicles.Bicycle;
import rf222cz_assign2.Exercide2_Ferry.Vehicles.Car;

/**
 * Created by ymafr on 2016-09-13.
 */
public class FerryMain {
    public static void main(String[] args) {

        Bicycle cykel = new Bicycle(1, 20);
        Car bil = new Car(cykel.space*5, 100, 3, 15, 4);
        Passenger linda = new Passenger(20);
        //Vehicle grönBil = new Vehicle();


        Ferry ferry = new Ferry();

        ferry.embark(bil);
        ferry.embark(bil);
        ferry.embark(linda);

        System.out.println(ferry.countPassengers());
        //System.out.println(ferry.countVehicleSpace());

    }
}
