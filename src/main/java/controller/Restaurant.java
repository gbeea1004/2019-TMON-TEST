package controller;

import domain.*;

public class Restaurant {
    private int currentMinuteTime;
    private WaitingRoom waitingRoom;
    private Tables tables;
    private Cooks cooks;
    private CleaningStaffs cleaningStaffs;

    public Restaurant(Cooks cooks, CleaningStaffs cleaningStaffs, Tables tables) {
        this.currentMinuteTime = -1;
        this.waitingRoom = new WaitingRoom();
        this.cooks = cooks;
        this.cleaningStaffs = cleaningStaffs;
        this.tables = tables;
    }

    public int open(int limitTime) {
        while (currentMinuteTime < limitTime) {
            currentMinuteTime++;
            checkEnterCustomers();
            waitingRoom.sitTableOrLeave(tables);

            tables.addOneMinute();

        }
        return 1;
    }

    private void checkEnterCustomers() {
        if (currentMinuteTime % 10 == 0) {
            enterCustomer();
        }
    }

    private void enterCustomer() {
        for (int i = 0; i < 7; i++) {
            waitingRoom.addCustomer(new Customer());
        }
    }
}
