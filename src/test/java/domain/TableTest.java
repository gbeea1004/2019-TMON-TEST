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

        table.sitCustomer(new Customer());
        assertThat(tables.sitOnTable()).isNull();
    }
}
