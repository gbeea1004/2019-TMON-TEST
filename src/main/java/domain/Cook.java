package domain;

public class Cook {
    private Customer target;
    private int currentCookingTime;

    public Cook() {
        this.currentCookingTime = 0;
    }

    public boolean isWorking() {
        return target != null;
    }

    public void setTarget(Customer customer) {
        if (isWorking()) {
            throw new IllegalArgumentException("요리사가 이미 일하고 있습니다.");
        }
        this.target = customer;
    }

    public void finishCooking() {
        this.target = null;
    }

    public void work() {
        if (!isWorking()) {
            throw new IllegalArgumentException("지정받은 손님이 없습니다.");
        }
        if (currentCookingTime == Constraint.WORKING_MINUTE_TIME_OF_COOK) {
            target.eatingStart();
            return;
        }
        currentCookingTime++;
    }
}
