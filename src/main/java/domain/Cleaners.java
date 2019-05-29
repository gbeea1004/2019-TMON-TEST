package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constraint.MAX_CLEANERS;
import static domain.Constraint.MIN;

public class Cleaners {
    private List<Cleaner> cleaners = new ArrayList<>();

    public Cleaners(int countOfCleaner) {
        if (MIN > countOfCleaner || countOfCleaner > MAX_CLEANERS) {
            throw new IllegalArgumentException("청소 스탭의 수를 정확히 입력하세요.");
        }
        for (int i = 0; i < countOfCleaner; i++) {
            cleaners.add(new Cleaner());
        }
    }

    public boolean isWorking() {
        for (Cleaner cleaner : cleaners) {
            if (cleaner.isWorking()) {
                return true;
            }
        }
        return false;
    }
}
