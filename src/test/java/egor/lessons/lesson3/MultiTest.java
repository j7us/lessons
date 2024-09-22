package egor.lessons.lesson3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiTest {

    @Test
    void test() {
        MultidimensionalDynArray<String> stringMultidimensionalDynArray
                = new MultidimensionalDynArray<>(String.class, 3, 5, 5, 5);

        stringMultidimensionalDynArray.append("AAAAAAAA", 0, 0, 0);

        String item = stringMultidimensionalDynArray.getItem(0, 0, 0);

        assertThat(item).isEqualTo("AAAAAAAA");
    }
}
