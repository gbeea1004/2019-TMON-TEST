package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {
    @Test
    public void 앉을_자리가_있는가() {
        Tables tables = new Tables(3);
        Table table = tables.sitOnTable();
        assertThat(table).isNotNull();
    }

    @Test
    public void 사람이_들어옴() {
        Tables tables = new Tables(1);
        Table table = tables.sitOnTable();
        assertThat(table).isNotNull();

        table.sitGuest(new Guest());
        assertThat(tables.sitOnTable()).isNull();
    }

    @Test
    public void 손님이_없는_테이블들() {
        Tables tables = new Tables(3);
        assertThat(tables.tablesOfSitGuestAndNoCook().size() == 0).isTrue();
    }

    @Test
    public void 손님이_있는_테이블들() {
        Tables tables = new Tables(3);
        tables.getTables().get(0).sitGuest(new Guest());
        assertThat(tables.tablesOfSitGuestAndNoCook().size() == 1).isTrue();
    }
}
