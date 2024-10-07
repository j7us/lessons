package egor.lessons.lesson7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderedListDuplicateRemoverTest {

    @Test
    void removeIntegerDuplicateTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(17);
        testList.add(17);
        testList.add(17);
        testList.add(45);
        testList.add(2);
        testList.add(2);
        testList.add(10);

        testList.removeDuplicate();

        assertThat(testList.count()).isEqualTo(5);
    }

    @Test
    void removeStringDuplicateTest() {
        OrderedList<String> testList = new OrderedList<>(false);


        testList.add("A");
        testList.add("A");

        testList.removeDuplicate();

        assertThat(testList.count()).isEqualTo(1);
    }
}
