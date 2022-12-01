package Class08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _05_CarsTestArrayList {
    public static void main(String[] args) {
        // Using ArrayList to store objects
        List<_03_Cars> cars = new ArrayList<>();
        cars.add(new Toyota("Gasoline"));
        cars.add(new Honda("Gasoline"));
        cars.add(new Tesla("Electric"));

        System.out.println("--- Enhanced Loop ---");
        for (_03_Cars car : cars) {
            car.fuelType();
        }

        System.out.println("--- For Loop ---");
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).fuelType();
        }

        System.out.println("--- Iterator ---");
        Iterator<_03_Cars> iterator = cars.iterator();
        while (iterator.hasNext()) {
            iterator.next().fuelType();
        }
    }
}
