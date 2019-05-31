package controller;

import domain.*;

import java.util.List;

public class Restaurant {
    private MeasureTime measureTime;
    private WaitingRoom waitingRoom;
    private Tables tables;
    private Cooks cooks;
    private Cleaners cleaners;

    public Restaurant(MeasureTime measureTime, Cooks cooks, Cleaners cleaners, Tables tables) {
        this.measureTime = measureTime;
        this.waitingRoom = new WaitingRoom();
        this.cooks = cooks;
        this.cleaners = cleaners;
        this.tables = tables;
    }

    public int open() {
        int numberOfCustomer = 0;
        while (measureTime.isOpening()) {
            measureTime.addOneMinute();
            visitGuests();
            while (true) {
                Table maybeTable = tables.sitOnTable();
                if (maybeTable == null) {
                    break;
                }

                if (waitingRoom.hasNotGuest()) {
                    break;
                }
                maybeTable.sitGuest(waitingRoom.leaveGuest());
            }

            // 테이블에 앉아있는 손님에게 요리사 배정
            List<Table> tablesOfSitGuestAndNoCook = tables.tablesOfSitGuestAndNoCook();
            for (Table table : tablesOfSitGuestAndNoCook) {
                Cook waitCook = cooks.findWaitCook();
                if (waitCook == null) {
                    break;
                }
                table.setCook(waitCook);
                table.startCook(); // 손님이 테이블에 앉으면 요리사는 바로 요리를 한다. (소요시간 4분)
            }

            // 손님은 식사를 한다. (소요시간 11분)
            for (Table table : tables.getTables()) {
                table.giveFood();
            }

            // 먹고 나간 손님
            for (Table table : tables.getTables()) {
                if (table.isFinishEating()) {
                    numberOfCustomer++;
                }
            }

            // 손님이 나가면 청소 스텝은 테이블을 정리합니다. (소요시간 3분)
            for (Table table : tables.getTables()) {
                if (!table.isClean()) {
                    Cleaner waitCleaner = cleaners.findWaitCleaner();
                    if (waitCleaner == null) {
                        break;
                    }
                    table.setCleaner(waitCleaner);
                    table.startCleaner();
                }
            }

            // TODO : 테이블 정리가 완료된 직후 다시 테이블을 사용할 수 있다.
            



            waitingRoom.addWaitingMinuteTime(); // 대기하는 사람들 1초 추가
            tables.addOneMinute();
        }
        return numberOfCustomer;
    }

    private void visitGuests() {
        if (measureTime.isCustomerEntryTime()) {
            enterWaitingRoom();
        }
    }

    private void enterWaitingRoom() {
        for (int i = 0; i < Constraint.COUNT_OF_VISIT_GUEST; i++) {
            waitingRoom.addGuest(new Guest());
        }
    }
}
