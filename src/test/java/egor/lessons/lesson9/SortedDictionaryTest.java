package egor.lessons.lesson9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedDictionaryTest {

    @Test
    void sortedTest() {
        SortedDictionary<String> stringSortedDictionary = new SortedDictionary<>();

        stringSortedDictionary.put("Andrey", "One");
        stringSortedDictionary.put("Vova", "Two");
        stringSortedDictionary.put("Artem", "Four");
        stringSortedDictionary.put("Vova", "AAAAAA");

        String res = stringSortedDictionary.get("Vova");

        assertThat(res).isEqualTo("AAAAAA");
    }
}
