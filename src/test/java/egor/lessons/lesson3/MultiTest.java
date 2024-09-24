package egor.lessons.lesson3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiTest {

    @Test
    void test() {
        MultidimensionalDynArray<String> array
                = new MultidimensionalDynArray<>(String.class, 3, 3, 5, 4);

        for (int i = 0; i < 3; i++) {
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 4; y++) {
                    array.append("AA", i, x, y);
                }
            }
        }

        array.append("B", 4, 1, 1);

        assertThat(array.getItem(4, 1, 1)).isEqualTo("B");
    }
}
