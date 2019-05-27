package domain;

public class Cook extends Employee {
    private Status status;

    public Cook() {
        super(Constraint.WORKING_MINUTE_TIME_OF_COOK);
    }

    // TODO : status Enum 구현
    public boolean isWorking() {
        return false;
    }
}
