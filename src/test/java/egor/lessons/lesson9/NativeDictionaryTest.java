package egor.lessons.lesson9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NativeDictionaryTest {

    @Test
    void putTest() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(1000, Integer.class);

        dictionary.put("A", 1);
        dictionary.put("B", 2);

        assertThat(dictionary.get("B")).isEqualTo(2);
    }

    @Test
    void isKeyTest() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(1000, Integer.class);

        dictionary.put("A", 1);
        dictionary.put("B", 2);

        assertThat(dictionary.isKey("")).isTrue();
    }
}
