package domain;

public class Table implements WhatNaming {
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
        sitGuest = null;
    }

    public boolean isSeat() {
        return sitGuest == null;
    }

    public boolean isNotAssignedCook() {
        return cook == null;
    }

    public void startCook() {
        cook.act();
    }

    public boolean isWorkingCook() {
        return cook.isActing();
    }

    public void giveFood() {
        if (cook.isFinish()) {
            sitGuest.act();
            cook = null;
        }
    }

    @Override
    public void addOneMinute() {
        if (sitGuest.isActing()) {
            sitGuest.addOneMinute();
        }

        if (cook.isActing()) {
            cook.addOneMinute();
        }
    }
}
