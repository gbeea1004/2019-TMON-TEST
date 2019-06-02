package domain;

public class Guest extends Person {
    private static final int MAX_WAITING_TIME = 60;
    private static final int MEAL_TIME = 11;

    public Guest() {
        super(MEAL_TIME, 0);
    }

    public boolean isOverWaiting() {
        return status == Status.WAIT && spendTime > MAX_WAITING_TIME;
    }
}
