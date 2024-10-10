package egor.lessons.lesson8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicHashTest {

    @Test
    void dynamicTest() {
        DynamicHashTable table = new DynamicHashTable();

        for (int i = 0; i < 1000; i++) {
            table.put("a" + i);
        }

        assertThat(table.size()).isEqualTo(1000);
    }
}
