package controller;

import domain.*;

public class Restaurant {
    private MeasureTime measureTime;
    private WaitingRoom waitingRoom;
    private Tables tables;
    private Cooks cooks;
    private CleaningStaffs cleaningStaffs;

    public Restaurant(MeasureTime measureTime, Cooks cooks, CleaningStaffs cleaningStaffs, Tables tables) {
        this.measureTime = measureTime;
        this.waitingRoom = new WaitingRoom();
        this.cooks = cooks;
        this.cleaningStaffs = cleaningStaffs;
        this.tables = tables;
    }

    public int open() {
        int numberOfCustomer = 0;
        while (measureTime.isOpening()) {
            measureTime.addOneMinute();
            visitCustomers();

            while (true) {
                waitingRoom.sitTableOrLeave(tables);
                Cook waitCook = cooks.findWaitCook();
                if (waitCook == null) {
                    break;
                }
                tables.sitOnTable();
            }

            tables.addOneMinute();

        }
        return numberOfCustomer;
    }

    private void visitCustomers() {
        if (measureTime.isCustomerEntryTime()) {
            enterWaitingRoom();
        }
    }

    private void enterWaitingRoom() {
        for (int i = 0; i < 7; i++) {
            waitingRoom.addCustomer(new Customer());
        }
    }
}
