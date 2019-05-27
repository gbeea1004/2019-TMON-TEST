package domain;

import java.util.ArrayList;
import java.util.List;

public class CleaningStaffs {
    private List<CleaningStaff> cleaningStaffs = new ArrayList<>();

    public CleaningStaffs(int countOfCleaningStaff) {
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
