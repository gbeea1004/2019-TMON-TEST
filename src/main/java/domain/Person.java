package domain;

public class Person implements WhatNaming {
    final int MAX_SPEND_TIME;
    Status status;
    int spendTime;

    Person(int MAX_SPEND_TIME) {
        init();
        this.MAX_SPEND_TIME = MAX_SPEND_TIME;
    }

    public void init() {
        status = Status.WAIT;
        spendTime = 0;
    }

    public void act() {
        spendTime = 0;
        status = Status.ACT;
    }

    public boolean isActing() {
        return status != Status.WAIT;
    }

    public boolean isFinish() {
        if (spendTime >= MAX_SPEND_TIME) {
            init();
            return true;
        }
        return false;
    }

    @Override
    public void addOneMinute() {
        spendTime++;
    }
}
