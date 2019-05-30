package domain;

public class Person implements WhatNaming {
    Status status;
    int currentActingTime;

    Person() {
        status = Status.WAIT;
        currentActingTime = 0;
    }

    public void act() {
        status = Status.ACT;
    }

    public boolean isActing() {
        return status != Status.WAIT;
    }

    @Override
    public void addOneMinute() {
        currentActingTime++;
    }
}
