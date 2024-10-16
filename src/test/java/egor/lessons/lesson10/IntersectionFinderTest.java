package egor.lessons.lesson10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionFinderTest {

    @Test
    void intersectionTest() {
        PowerSet set1 = new PowerSet();
        set1.put("A");
        set1.put("B");
        set1.put("C");
        set1.put("D");
        set1.put("G");

        PowerSet set2 = new PowerSet();
        set2.put("A");
        set2.put("6");
        set2.put("2");
        set2.put("D");
        set2.put("G");

        PowerSet set3 = new PowerSet();
        set3.put("4");
        set3.put("6");
        set3.put("2");
        set3.put("D");
        set3.put("G");

        PowerSet set4 = new PowerSet();
        set4.put("A1");
        set4.put("6");
        set4.put("2");
        set4.put("D");
        set4.put("G");

        PowerSet set5 = new PowerSet();
        set5.put("A");
        set5.put("6");
        set5.put("2");
        set5.put("D");
        set5.put("qwe");

        PowerSet res = IntersectionFinder.intersection(List.of(set1, set2, set3, set4, set5));

        assertThat(res.size()).isEqualTo(1);
    }
}
