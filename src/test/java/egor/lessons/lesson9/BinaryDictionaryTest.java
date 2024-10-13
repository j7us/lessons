package egor.lessons.lesson9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryDictionaryTest {

    @Test
    void dictionaryTest() {
        BinaryDictionary<String> stringBinaryDictionary = new BinaryDictionary<>(16, String.class);

        stringBinaryDictionary.put("Andrey", "One");
        stringBinaryDictionary.put("Vova", "Two");
        stringBinaryDictionary.put("Artem", "Four");

        String res = stringBinaryDictionary.get("Artem");

        assertThat(res).isEqualTo("Four");
    }
}
