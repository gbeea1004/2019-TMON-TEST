package domain;

import java.util.ArrayList;
import java.util.List;

public class Cooks {
    private List<Cook> cooks = new ArrayList<>();

    public Cooks(int countOfCook) {
        for (int i = 0; i < countOfCook; i++) {
            cooks.add(new Cook());
        }
    }

    public boolean isWorking() {
        for (Cook cook : cooks) {
            if (cook.isWorking()) {
                return true;
            }
        }
        return false;
    }
}
