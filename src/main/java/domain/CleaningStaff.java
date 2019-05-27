package domain;

public class CleaningStaff extends Employee {
    private Status status;

    public CleaningStaff() {
        super(3);
    }

    // TODO : status Enum 구현
    public boolean isWorking() {
        return false;
    }
}
