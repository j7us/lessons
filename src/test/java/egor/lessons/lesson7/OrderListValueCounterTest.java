package egor.lessons.lesson7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderListValueCounterTest {

    @Test
    void countTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(5);
        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(2);
        testList.add(10);

        Integer res = OrderListValueCounter.getMaxCountValue(testList);

        assertThat(res).isEqualTo(2);
    }
}
