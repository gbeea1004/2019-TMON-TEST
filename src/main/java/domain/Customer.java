package domain;

public class Customer {
    private final int MAX_WAITING_MINUTE_TIME = 3600;
    private int waitingMinuteTime;

    public boolean isOverWaiting() {
        if (waitingMinuteTime > MAX_WAITING_MINUTE_TIME) {
            return true;
        }
        return false;
    }
}
