package egor.lessons.lesson8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTableTest {

    @Test
    void hashTest() {
        HashTable table = new HashTable(19, 3);

        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");
        table.put("Test1");

        int res = table.put("Test1");

        assertThat(res).isEqualTo(-1);
    }

    @Test
    void findTest() {
        HashTable table = new HashTable(19, 3);

        table.put("Test1");
        table.put("Test2");
        table.put("Test21");
        table.put("Test3");
        table.put("Test4");
        table.put("Test5");
        table.put("Test6");
        table.put("Test7");
        table.put("Test8");

        int test9 = table.put("Test9");

        int res = table.find("Test9");

        assertThat(res).isEqualTo(test9);
    }

    @Test
    void findFalseTest() {
        HashTable table = new HashTable(19, 3);

        table.put("Test1");
        table.put("Test2");
        table.put("Test21");

        int res = table.find("Test0000000101ad");

        assertThat(res).isEqualTo(-1);
    }
}
