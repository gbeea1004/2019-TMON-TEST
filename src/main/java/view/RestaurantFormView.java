package view;

import domain.CleaningStaffs;
import domain.Cooks;
import domain.Tables;
import utils.Conversion;

import java.util.Scanner;

import static domain.Constraint.MIN;

public class RestaurantFormView {
    public static int inputMeasuringTime(Scanner scanner) {
        System.out.print("측정시간 : ");
        int limitTime = Conversion.toInt(scanner.nextLine());
        if (MIN > limitTime) {
            throw new IllegalArgumentException("측정 시간은 " + MIN + "이상의 값을 입력해야 합니다.");
        }
        return limitTime * 60; // 시 -> 분 단위로 변환
    }

    public static Cooks inputCountOfCook(Scanner scanner) {
        System.out.print("요리사 수 : ");
        return new Cooks(Conversion.toInt(scanner.nextLine()));
    }

    public static CleaningStaffs inputCountOfCleaningStaff(Scanner scanner) {
        System.out.print("청소 스탭 수 : ");
        return new CleaningStaffs(Conversion.toInt(scanner.nextLine()));
    }

    public static Tables inputCountOfTable(Scanner scanner) {
        System.out.print("테이블 수 : ");
        return new Tables(Conversion.toInt(scanner.nextLine()));
    }
}
