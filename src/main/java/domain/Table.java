package domain;

public class Table {
    private Guest sitGuest;
    private Cook cook;

    public void sitGuest(Guest guest) {
        this.sitGuest = guest;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void finishEating() {
        if (sitGuest.isFinish()) {
            leaveCustomer();
        }
    }

    private void leaveCustomer() {
        this.sitGuest = null;
    }

    public boolean isSeat() {
        return sitGuest == null;
    }

    public boolean isNotAssignedCook() {
        return cook == null;
    }
}
