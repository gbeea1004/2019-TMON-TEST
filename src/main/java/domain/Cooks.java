package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constraint.MAX_COOKS;
import static domain.Constraint.MIN;

public class Cooks {
    private List<Cook> cooks = new ArrayList<>();

    public Cooks(int countOfCook) {
        if (MIN > countOfCook || countOfCook > MAX_COOKS) {
            throw new IllegalArgumentException("요리사의 수를 정확히 입력하세요.");
        }
        for (int i = 0; i < countOfCook; i++) {
            cooks.add(new Cook());
        }
    }

    public Cook findWaitCook() {
        return cooks.stream().filter(c -> !c.isWork()).findFirst().orElse(null);
    }
}
