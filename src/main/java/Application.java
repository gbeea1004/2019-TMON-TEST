import controller.Restaurant;
import domain.Cooks;

import java.util.Scanner;

import static view.RestaurantFormView.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int measuringTime = inputMeasuringTime(scanner);
        Restaurant restaurant = new Restaurant(inputCountOfCook(scanner), inputCountOfCleaningStaff(scanner), inputCountOfTable(scanner));
        restaurant.open(measuringTime);
        scanner.close();
    }
}
