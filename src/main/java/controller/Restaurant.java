package controller;

import domain.*;

import java.util.List;

/*
    < 요구사항 >
    손님이 테이블에 앉으면 요리사는 바로 요리를 한다. (소요시간 4분)
    손님은 식사를 한다. (소요시간 11분)
    손님이 나가면 청소 스텝은 테이블을 정리합니다. (소요시간 3분)
*/
public class Restaurant {
    private MeasureTime measureTime;
    private WaitingRoom waitingRoom;
    private Tables tables;
    private Cooks cooks;
    private Cleaners cleaners;
    private int numberOfCustomer;

    public Restaurant(MeasureTime measureTime, Cooks cooks, Cleaners cleaners, Tables tables) {
        this.measureTime = measureTime;
        this.waitingRoom = new WaitingRoom();
        this.cooks = cooks;
        this.cleaners = cleaners;
        this.tables = tables;
        numberOfCustomer = 0;
    }

    public int open() {
        while (measureTime.isOpening()) {
            visitGuests();
            measureTime.addOneMinute();
            // 대기손님 테이블로 이동
            designateTable();

            // 테이블에 앉아있는 손님에게 요리사 배정
            designateCook();

            // 손님에게 식사를 건낸다.
            giveFoodToGuest();

            // 먹고 나간 손님
            leaveRestaurant();

            // 손님이 나가면 청소 스텝은 테이블을 정리합니다. (소요시간 3분)
            designateCleaner();

            // 테이블 정리가 완료된 직후 다시 테이블을 사용할 수 있다.
            completeCleaning();

            waitingRoom.addWaitingMinuteTime(); // 대기하는 사람들 1초 추가
            tables.addOneMinute(); // 테이블에 앉은 손님과 테이블 담당자들 1초 추가
        }
        return numberOfCustomer;
    }

    private void completeCleaning() {
        for (Table table : tables.getTables()) {
            table.finishClean();
        }
    }

    private void designateCleaner() {
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
    }

    private void leaveRestaurant() {
        for (Table table : tables.getTables()) {
            if (table.isFinishEating()) {
                numberOfCustomer++;
            }
        }
    }

    private void giveFoodToGuest() {
        for (Table table : tables.getTables()) {
            table.giveFood();
        }
    }

    private void designateTable() {
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
    }

    private void designateCook() {
        List<Table> tablesOfSitGuestAndNoCook = tables.tablesOfSitGuestAndNoCook();
        for (Table table : tablesOfSitGuestAndNoCook) {
            Cook waitCook = cooks.findWaitCook();
            if (waitCook == null) {
                break;
            }
            table.setCook(waitCook);
            table.startCook(); // 손님이 테이블에 앉으면 요리사는 바로 요리를 한다. (소요시간 4분)
        }
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
