package controller;

import domain.WaitingRoom;

public class Restaurant {
    private int currentMinuteTime;
    private WaitingRoom waitingRoom;

    public Restaurant() {
        this.currentMinuteTime = 0;
        this.waitingRoom = new WaitingRoom();
    }

    public int open(int limitTime, int countOfCook, int countOfCleaningStaff, int countOfTable) {
        while (currentMinuteTime < limitTime) {
            if (currentMinuteTime % 10 == 0) {

            }

            currentMinuteTime++;
        }

        return 1;
    }
}
