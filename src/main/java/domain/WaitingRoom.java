package domain;

import java.util.LinkedList;
import java.util.Queue;

// 일급 컬랙션
public class WaitingRoom {
    private Queue<Customer> waitingRoom = new LinkedList<>();

    public void addCustomer(Customer customer) {
        waitingRoom.add(customer);
    }

    public void sitTableOrLeave(Tables tables) {
        if (waitingRoom.isEmpty()) {
            return;
        }
        for (Table table : tables.getTables()) {
            checkTableStatus(table);
        }
    }

    private void checkTableStatus(Table table) {
        if (table.isSeat()) {
            confirmCustomerStatus(table);
        }
    }

    private void confirmCustomerStatus(Table table) {
        while (!waitingRoom.isEmpty()) {
            if (waitingRoom.peek().isOverWaiting()) {
                waitingRoom.poll();
                continue;
            }
            table.sitCustomer(waitingRoom.poll());
            break;
        }
    }
}
