package domain;

public class Cook extends Employee {
    private Status status;

    public Cook() {
        super(3);
    }

    // TODO : status Enum 구현
    public boolean isWorking() {
        return false;
    }
}
