package domain;

public class CleaningStaff extends Employee {
    private Status status;

    public CleaningStaff() {
        super(Constraint.WORKING_MINUTE_TIME_OF_CLEANING_STAFF);
    }

    // TODO : status Enum 구현
    public boolean isWorking() {
        return false;
    }
}
