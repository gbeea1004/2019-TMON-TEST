package domain;

public class Person implements WhatNaming {
    final int actingMaxTime;
    Status status;
    int currentActingTime;

    Person(int actingMaxTime) {
        status = Status.WAIT;
        currentActingTime = 0;
        this.actingMaxTime = actingMaxTime;
    }

    public void act() {
        status = Status.ACT;
    }

    public boolean isActing() {
        return status != Status.WAIT;
    }

    public boolean isFinish() {
        if (currentActingTime > actingMaxTime) {
            status = Status.WAIT;
            currentActingTime = 0;
            return true;
        }
        return false;
    }

    @Override
    public void addOneMinute() {
        currentActingTime++;
    }
}
