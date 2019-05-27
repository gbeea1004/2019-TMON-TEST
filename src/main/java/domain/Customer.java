package domain;

public class Customer {
    private int waitingMinuteTime;

    public boolean isOverWaiting() {
        if (waitingMinuteTime > Constraint.MAX_WAITING_MINUTE_TIME_OF_CUSTOMER) {
            return true;
        }
        return false;
    }
}
