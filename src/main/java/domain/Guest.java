package domain;

public class Guest {
    private int waitingMinuteTime;
    private Status status;

    public Guest() {
        this.status = Status.WAIT;
    }

    public boolean isOverWaiting() {
        return waitingMinuteTime > Constraint.MAX_WAITING_MINUTE_TIME_OF_CUSTOMER;
    }

    public void eatingStart() {
        this.status = Status.EATING;
    }

    public boolean isEating() {
        return status == Status.EATING;
    }

    public void addwaitingMinuteTime() {
        this.waitingMinuteTime++;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "waitingMinuteTime=" + waitingMinuteTime +
                ", status=" + status +
                '}';
    }
}
