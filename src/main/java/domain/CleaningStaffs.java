package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constraint.MAX_CLEANING_STAFFS;
import static domain.Constraint.MIN;

public class CleaningStaffs {
    private List<CleaningStaff> cleaningStaffs = new ArrayList<>();

    public CleaningStaffs(int countOfCleaningStaff) {
        if (MIN > countOfCleaningStaff || countOfCleaningStaff > MAX_CLEANING_STAFFS) {
            throw new IllegalArgumentException("청소 스탭의 수를 정확히 입력하세요.");
        }
        for (int i = 0; i < countOfCleaningStaff; i++) {
            cleaningStaffs.add(new CleaningStaff());
        }
    }

    public boolean isWorking() {
        for (CleaningStaff cleaningStaff : cleaningStaffs) {
            if (cleaningStaff.isWorking()) {
                return true;
            }
        }
        return false;
    }
}
