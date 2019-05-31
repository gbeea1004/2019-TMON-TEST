package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return tables.stream()
                .filter(Table::isSeat)
                .filter(Table::isClean)
                .findFirst()
                .orElse(null);
    }

    public List<Table> getTables() {
        return tables;
    }

    public void addOneMinute() {
        for (Table table : tables) {
            table.addOneMinute();
        }
    }

    public List<Table> tablesOfSitGuestAndNoCook() {
        return tables.stream()
                .filter(t -> !t.isSeat())
                .filter(Table::isNotAssignedCook)
                .collect(Collectors.toList());
    }
}
