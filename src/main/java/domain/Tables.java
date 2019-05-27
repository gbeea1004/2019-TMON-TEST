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

    public Table getSitOn() {
        for (Table table : tables) {
            if (table.canSit()) {
                return table;
            }
        }
        return null;
    }
}
