package domain;

public class Person implements WhatNaming {
    final int MAX_SPEND_TIME;
    Status status;
    int spendTime;

    // 숙련도 : '0 ~ MAX - 1' 까지 가능
    Person(int MAX_SPEND_TIME, int proficiency) {
        if (MAX_SPEND_TIME - proficiency <= 0) {
            throw new IllegalArgumentException("숙련도를 잘못 입력하셨습니다.");
        }
        init();
        this.MAX_SPEND_TIME = MAX_SPEND_TIME - proficiency;
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
