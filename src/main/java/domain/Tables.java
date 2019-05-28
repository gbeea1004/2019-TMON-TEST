package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constraint.MAX_TABLES;
import static domain.Constraint.MIN;

public class Tables {
    private List<Table> tables = new ArrayList<>();

    public Tables(int countOfTable) {
        if (MIN > countOfTable || countOfTable > MAX_TABLES) {
            throw new IllegalArgumentException("테이블의 수를 정확히 입력하세요.");
        }
        for (int i = 0; i < countOfTable; i++) {
            tables.add(new Table());
        }
    }

    public Table sitOnTable() {
        for (Table table : tables) {
            if (table.isSeat()) {
                return table;
            }
        }
        return null;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void addOneMinute() {
        for (Table table : tables) {
            table.addOneMinute();
        }
    }
}
