package Class08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarsTestArrayList {
    public static void main(String[] args) {
        // Using ArrayList to store objects
        List<Cars> cars = new ArrayList<>();
        cars.add(new Toyota("Gasoline"));
        cars.add(new Honda("Gasoline"));
        cars.add(new Tesla("Electric"));

        System.out.println("--- Enhanced Loop ---");
        for (Cars car : cars) {
            car.fuelType();
        }

        System.out.println("--- For Loop ---");
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).fuelType();
        }

        System.out.println("--- Iterator ---");
        Iterator<Cars> iterator = cars.iterator();
        while (iterator.hasNext()) {
            iterator.next().fuelType();
        }
    }
}
