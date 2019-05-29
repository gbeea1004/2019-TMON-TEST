package domain;

public class Cook {
    private Status status;
    private int currentCookingTime;

    public Cook() {
        this.currentCookingTime = 0;
        status = Status.WAIT;
    }

    public void working() {
        status = Status.WORK;
    }

    public boolean isWork() {
        return status == Status.WORK;
    }

    public void addCurrentCookingTime() {
        currentCookingTime++;
    }
}
