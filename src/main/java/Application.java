import controller.Restaurant;

import java.util.Scanner;

import static view.RestaurantFormView.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurant.open(limitTime(scanner), countOfCook(scanner), countOfCleaningStaff(scanner), countOfTable(scanner));
        scanner.close();
    }
}
