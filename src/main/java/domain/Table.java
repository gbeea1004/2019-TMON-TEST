package domain;

public class Table implements WhatNaming {
    private Guest sitGuest;
    private Cook cook;
    private Cleaner cleaner;
    private boolean isClean = true;

    public void sitGuest(Guest guest) {
        this.sitGuest = guest;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    public void setCleaner(Cleaner cleaner) {
        this.cleaner = cleaner;
    }

    public boolean isFinishEating() {
        if (sitGuest.status == Status.ACT && sitGuest.isFinish()) {
            leaveCustomer();
            isClean = false;
            return true;
        }
        return false;
    }

    private void leaveCustomer() {
        sitGuest = null;
    }

    public boolean isSeat() {
        return sitGuest == null;
    }

    public boolean isClean() {
        return isClean;
    }

    public boolean isNotAssignedCook() {
        return cook == null;
    }

    public void startCook() {
        cook.act();
    }

    public void startCleaner() {
        cleaner.act();
    }

    public void giveFood() {
        if (cook.status == Status.ACT && cook.isFinish()) {
            sitGuest.act();
            cook.init();
            cook = null;
        }
    }

    public void finishClean() {
        if (cleaner.status == Status.ACT && cleaner.isFinish()) {
            cleaner.init();
            isClean = true;
            cleaner = null;
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

        if (cleaner.isActing()) {
            cleaner.addOneMinute();
        }
    }
}
