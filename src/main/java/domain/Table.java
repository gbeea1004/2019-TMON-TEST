package domain;

public class Table {
    private Customer sitCustomer;
    private Cook cook;
    private int currentUsingTime;

    public void sitCustomer(Customer customer) {
        this.sitCustomer = customer;
        currentUsingTime = 0;
    }

    public void finishEating() {
        if (currentUsingTime > Constraint.MEAL_MINUTE_TIME_OF_CUSTOMER) {
            leaveCustomer();
        }
    }

    private void leaveCustomer() {
        this.sitCustomer = null;
        currentUsingTime = 0;
    }

    public boolean isSeat() {
        return sitCustomer == null;
    }

    public void addOneMinute() {
        if (sitCustomer.isEating()) {
            this.currentUsingTime++;
        }
    }
}
