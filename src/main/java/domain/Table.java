package domain;

public class Table implements WhatNaming {
    private Guest sitGuest;
    private Cook cook;
    private int currentUsingTime;

    public void sitGuest(Guest guest) {
        this.sitGuest = guest;
        currentUsingTime = 0;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void finishEating() {
        if (currentUsingTime > Constraint.MEAL_MINUTE_TIME_OF_CUSTOMER) {
            leaveCustomer();
        }
    }

    private void leaveCustomer() {
        this.sitGuest = null;
        currentUsingTime = 0;
    }

    public boolean isSeat() {
        return sitGuest == null;
    }

    public boolean isNotAssignedCook() {
        return cook == null;
    }

    @Override
    public void addOneMinute() {
        if (sitGuest != null) {
            currentUsingTime++;
        }
    }
}
