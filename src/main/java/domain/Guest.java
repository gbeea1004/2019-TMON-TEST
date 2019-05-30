package domain;

public class Guest extends Person {
    private static final int MAX_WAITING_TIME = 3600;
    private static final int MEAL_TIME = 11;

    public Guest() {
        super(MEAL_TIME);
    }

    public boolean isOverWaiting() {
        return status == Status.WAIT && spendTime > MAX_WAITING_TIME;
    }
}
