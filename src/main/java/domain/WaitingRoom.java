package domain;

import java.util.LinkedList;
import java.util.Queue;

// 일급 컬랙션
public class WaitingRoom {
    private Queue<Guest> waitingRoom = new LinkedList<>();

    public void addGuest(Guest guest) {
        waitingRoom.add(guest);
    }

    public void addwaitingMinuteTime() {
        for (Guest guest : waitingRoom) {
            guest.addwaitingMinuteTime();
        }
    }

    public boolean isGuest() {
        return !waitingRoom.isEmpty();
    }

    public Guest moveGuest() {
        return waitingRoom.poll();
    }
}
