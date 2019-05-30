package domain;

public class Guest extends Person {
    private int waitingMinuteTime;

    public boolean isOverWaiting() {
        return waitingMinuteTime > Constraint.MAX_WAITING_MINUTE_TIME_OF_CUSTOMER;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "waitingMinuteTime=" + waitingMinuteTime +
                ", status=" + status +
                '}';
    }
}
