package domain;

public class Employee {
    private final int workingMinuteTime;

    public Employee(int workingMinuteTime) {
        this.workingMinuteTime = workingMinuteTime;
    }

    public int getWorkingMinuteTime() {
        return workingMinuteTime;
    }
}
