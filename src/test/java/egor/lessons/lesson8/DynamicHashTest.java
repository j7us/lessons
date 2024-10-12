package egor.lessons.lesson8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicHashTest {

    @Test
    void dynamicTest() {
        DynamicHashTable table = new DynamicHashTable();

        for (int i = 0; i < 1000; i++) {
            table.put("a" + i);
        }

        System.out.println("done");
    }

    @Test
    void dynamicATest() {
        System.out.println(42761%16);
        System.out.println(42761%32);
    }

    @Test
    void array() {
        ArrayList<String> strings = new ArrayList<>(16);
        strings.add(15, "AAA");
        System.out.println(strings.get(15));
    }
}
