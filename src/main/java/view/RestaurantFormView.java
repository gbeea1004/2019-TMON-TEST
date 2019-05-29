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
        return new Cooks(Conversion.toInt(scanner.nextLine()));
    }

    public static Cleaners inputCountOfCleaningStaff(Scanner scanner) {
        System.out.print("청소 스탭 수 : ");
        return new Cleaners(Conversion.toInt(scanner.nextLine()));
    }

    public static Tables inputCountOfTable(Scanner scanner) {
        System.out.print("테이블 수 : ");
        return new Tables(Conversion.toInt(scanner.nextLine()));
    }
}
