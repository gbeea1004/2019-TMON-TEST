package domain;

import java.util.ArrayList;
import java.util.List;

public class Tables {
    private List<Table> tables = new ArrayList<>();

    public Tables(int countOfTable) {
        for (int i = 0; i < countOfTable; i++) {
            tables.add(new Table());
        }
    }

    public boolean isSitOn() {
        for (Table table : tables) {
            if (table.canSit()) {
                return true;
            }
        }
        return false;
    }
}
