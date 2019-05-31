package domain;

import java.util.LinkedList;
import java.util.Queue;

// 일급 컬랙션
public class WaitingRoom {
    private Queue<Guest> waitingRooms = new LinkedList<>();

    public void addGuest(Guest guest) {
        waitingRooms.add(guest);
    }

    public void addWaitingMinuteTime() {
        waitTooLongToLeave();
        for (Guest guest : waitingRooms) {
            guest.addOneMinute();
        }
    }

    public boolean hasNotGuest() {
        return waitingRooms.isEmpty();
    }

    public Guest leaveGuest() {
        return waitingRooms.poll();
    }

    public void waitTooLongToLeave() {
        long countOfLeaveGuest = waitingRooms.stream()
                .filter(g -> g.isOverWaiting())
                .count();

        for (int i = 0; i < countOfLeaveGuest; i++) {
            waitingRooms.poll();
        }
    }
}
