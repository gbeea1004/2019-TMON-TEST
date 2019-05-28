package domain;

import static domain.Constraint.MIN;

public class MeasureTime {
    private final int MEASURE_TIME;
    private int currentMinuteTime;

    public MeasureTime(int MeasureTime) {
        if (MIN > MeasureTime) {
            throw new IllegalArgumentException("측정 시간을 정확히 입력하세요.");
        }
        MEASURE_TIME = MeasureTime * 60;
        currentMinuteTime = 0;
    }

    public boolean isOpening() {
        return currentMinuteTime <= MEASURE_TIME;
    }

    public void addOneMinute() {
        currentMinuteTime++;
    }

    public boolean isCustomerEntryTime() {
        return currentMinuteTime % 10 == 0;
    }
}
