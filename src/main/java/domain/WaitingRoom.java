package domain;

import java.util.LinkedList;
import java.util.Queue;

// 일급 컬랙션
public class WaitingRoom {
    private Queue<Customer> waitingRoom = new LinkedList<>();

    public void addCustomer(Customer customer) {
        waitingRoom.add(customer);
    }

    public Customer sitTableOrLeave(Tables tables) {
        if (waitingRoom.isEmpty()) {
            return null;
        }
        return waitingRoom.poll();
    }
}
