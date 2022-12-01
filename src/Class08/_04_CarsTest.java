package Class08;

import java.util.Arrays;
import java.util.Iterator;

public class _04_CarsTest {
    public static void main(String[] args) {
        // Regular way of storing objects in an array
        _03_Cars[] carsArray = {
                new Toyota("Gasoline"),
                new Honda("Gasoline"),
                new Tesla("Electric")
        };

        System.out.println("--- Enhanced Loop ---");
        for (_03_Cars car : carsArray) {
            car.fuelType();
        }

        System.out.println("--- For Loop ---");
        for (int i = 0; i < carsArray.length; i++) {
            carsArray[i].fuelType();
        }

        System.out.println("--- Iterator ---");
        Iterator<_03_Cars> iterator = Arrays.stream(carsArray).iterator();
        while (iterator.hasNext()) {
            iterator.next().fuelType();
        }
    }
}
