package domain;

public class Customer {
    private int waitingMinuteTime;
    private Status status;

    public Customer() {
        this.status = Status.WAIT;
    }

    public boolean isOverWaiting() {
        return waitingMinuteTime > Constraint.MAX_WAITING_MINUTE_TIME_OF_CUSTOMER;
    }

    public void eatingStart() {
        this.status = Status.WORK;
    }

    public boolean isEating() {
        return status == Status.WORK;
    }
}
