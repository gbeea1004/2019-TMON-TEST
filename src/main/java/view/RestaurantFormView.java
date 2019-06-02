package view;

import domain.Cleaners;
import domain.Cooks;
import domain.Tables;
import domain.MeasureTime;
import utils.Conversion;

import java.util.Scanner;

public class RestaurantFormView {
    public static MeasureTime inputMeasuringTime(Scanner scanner) {
        System.out.print("측정시간 : ");
        return new MeasureTime(Conversion.toInt(scanner.nextLine()));
    }

    public static Cooks inputCountOfCook(Scanner scanner) {
        System.out.print("요리사 수 : ");
        int countOfCook = Conversion.toInt(scanner.nextLine());
        System.out.print("요리사의 숙련도 : ");
        int proficiency = Conversion.toInt(scanner.nextLine());
        return new Cooks(countOfCook, proficiency);
    }

    public static Cleaners inputCountOfCleaningStaff(Scanner scanner) {
        System.out.print("청소 스탭 수 : ");
        int countOfCleaner = Conversion.toInt(scanner.nextLine());
        System.out.print("청소 스탭의 숙련도 : ");
        int proficiency = Conversion.toInt(scanner.nextLine());
        return new Cleaners(countOfCleaner, proficiency);
    }

    public static Tables inputCountOfTable(Scanner scanner) {
        System.out.print("테이블 수 : ");
        return new Tables(Conversion.toInt(scanner.nextLine()));
    }
}
