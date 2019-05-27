package domain;

public class Table {
    private Customer sitCustomer;

    public void sitCustomer(Customer customer) {
        this.sitCustomer = customer;
    }

    public void leaveCustomer() {
        this.sitCustomer = null;
    }

    public boolean canSit() {
        if (sitCustomer == null) {
            return true;
        }
        return false;
    }
}
