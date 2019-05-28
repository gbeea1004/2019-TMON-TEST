import controller.Restaurant;
import domain.Cooks;
import view.RestaurantResultView;

import java.util.Scanner;

import static view.RestaurantFormView.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant restaurant = new Restaurant(inputMeasuringTime(scanner), inputCountOfCook(scanner), inputCountOfCleaningStaff(scanner), inputCountOfTable(scanner));
        RestaurantResultView.show(restaurant.open());
        scanner.close();
    }
}
