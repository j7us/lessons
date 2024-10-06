package egor.lessons.lesson7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderedListMergerTest {

    @Test
    void mergeIntegerTest() {
        OrderedList<Integer> first = new OrderedList<>(true);

        first.add(7);
        first.add(8);
        first.add(9);
        first.add(10);

        OrderedList<Integer> second = new OrderedList<>(true);

        second.add(1);
        second.add(12);
        second.add(2);
        second.add(5);

        OrderedList<Integer> res = OrderedListMerger.mergeList(first, second, true);

        assertThat(res.tail.value).isEqualTo(12);
    }

    @Test
    void mergeIntegerOnlyElementTest() {
        OrderedList<Integer> first = new OrderedList<>(true);

        first.add(7);

        OrderedList<Integer> second = new OrderedList<>(true);

        second.add(1);

        OrderedList<Integer> res = OrderedListMerger.mergeList(first, second, true);

        assertThat(res.tail.value).isEqualTo(7);
    }
}
