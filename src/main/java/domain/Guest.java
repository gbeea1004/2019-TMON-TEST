package domain;

public class Guest extends Person {
    private static final int MAX_WAITING_TIME = 3600;
    private static final int MEAL_TIME = 11;
    private int waitingMinuteTime;

    Guest() {
        super(MEAL_TIME);
    }

    public boolean isOverWaiting() {
        return waitingMinuteTime > MAX_WAITING_TIME;
    }

    public void addWaitingMinuteTime() {
        waitingMinuteTime++;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "waitingMinuteTime=" + waitingMinuteTime +
                ", status=" + status +
                '}';
    }
}
