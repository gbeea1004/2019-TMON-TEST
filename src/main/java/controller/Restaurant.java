package controller;

import domain.*;

public class Restaurant {
    private int currentMinuteTime;
    private WaitingRoom waitingRoom;
    private Tables tables;
    private Cooks cooks;
    private CleaningStaffs cleaningStaffs;

    public Restaurant() {
        this.currentMinuteTime = -1;
        this.waitingRoom = new WaitingRoom();
    }

    public int open(int limitTime, int countOfCook, int countOfCleaningStaff, int countOfTable) {
        init(countOfCook, countOfCleaningStaff, countOfTable);

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

    private void init(int countOfCook, int countOfCleaningStaff, int countOfTable) {
        tables = new Tables(countOfTable);
        cooks = new Cooks(countOfCook);
        cleaningStaffs = new CleaningStaffs(countOfCleaningStaff);
    }
}
