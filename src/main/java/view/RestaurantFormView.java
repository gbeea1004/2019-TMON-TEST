package view;

import utils.Conversion;

import java.util.Scanner;

public class RestaurantFormView extends Exception {
    private static final int MIN = 1;
    private static final int MAX_COOKS = 100;
    private static final int MAX_CLEANING_STAFFS = 200;
    private static final int MAX_TABLES = 10000;

    public static int limitTime(Scanner scanner) {
        System.out.print("측정시간 : ");
        int limitTime = Conversion.toInt(scanner.nextLine());
        if (MIN > limitTime) {
            throw new IllegalArgumentException("측정 시간은 " + MIN + "이상의 값을 입력해야 합니다.");
        }
        return limitTime * 60; // 시 -> 분 단위로 변환
    }

    public static int countOfCook(Scanner scanner) {
        System.out.print("요리사 수 : ");
        int countOfCook = Conversion.toInt(scanner.nextLine());
        if (MIN > countOfCook || countOfCook > MAX_COOKS) {
            throw new IllegalArgumentException("요리사의 수는 " + MIN + " ~ " + MAX_COOKS + "명 사이의 값을 입력해야 합니다.");
        }
        return countOfCook;
    }

    public static int countOfCleaningStaff(Scanner scanner) {
        System.out.print("청소 스탭 수 : ");
        int countOfCleaningStaff = Conversion.toInt(scanner.nextLine());
        if (MIN > countOfCleaningStaff || countOfCleaningStaff > MAX_CLEANING_STAFFS) {
            throw new IllegalArgumentException("청소 스탭의 수는 " + MIN + " ~ " + MAX_CLEANING_STAFFS + "명 사이의 값을 입력해야 합니다.");
        }
        return countOfCleaningStaff;
    }

    public static int countOfTable(Scanner scanner) {
        System.out.print("테이블 수 : ");
        int countOfTable = Conversion.toInt(scanner.nextLine());
        if (MIN > countOfTable || countOfTable > MAX_TABLES) {
            throw new IllegalArgumentException("테이블의 수는 " + MIN + " ~ " + MAX_TABLES + "명 사이의 값을 입력해야 합니다.");
        }
        return countOfTable;
    }
}
