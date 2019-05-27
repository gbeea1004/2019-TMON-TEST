package domain;

public class Customer {
    private int waitingMinuteTime;
    private Status status;

    public Customer() {
        this.status = Status.WAIT;
    }

    public boolean isOverWaiting() {
        if (waitingMinuteTime > Constraint.MAX_WAITING_MINUTE_TIME_OF_CUSTOMER) {
            return true;
        }
        return false;
    }

    public void eatingStart() {
        this.status = Status.WORK;
    }

    public boolean isEating() {
        if (status == Status.WORK) {
            return true;
        }
        return false;
    }
}
