package domain;

public class Person implements WhatNaming {
    final int actingMaxTime;
    Status status;
    int currentActingTime;

    Person(int actingMaxTime) {
        init();
        this.actingMaxTime = actingMaxTime;
    }

    private void init() {
        status = Status.WAIT;
        currentActingTime = 0;
    }

    public void act() {
        currentActingTime = 0;
        status = Status.ACT;
    }

    public boolean isActing() {
        return status != Status.WAIT;
    }

    public boolean isFinish() {
        if (currentActingTime > actingMaxTime) {
            init();
            return true;
        }
        return false;
    }

    @Override
    public void addOneMinute() {
        currentActingTime++;
    }
}
