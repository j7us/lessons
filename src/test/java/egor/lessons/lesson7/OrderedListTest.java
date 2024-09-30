package egor.lessons.lesson7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderedListTest {

    @Test
    void orderIntegerTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        assertThat(testList.tail.value).isEqualTo(17);
    }

    @Test
    void orderIntegerFindTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        Node<Integer> res = testList.find(10);

        assertThat(res.value).isEqualTo(10);
    }

    @Test
    void orderIntegerFindEmptyTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        Node<Integer> res = testList.find(1000);

        assertThat(res).isNull();
    }

    @Test
    void orderIntegerCountTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        assertThat(testList.count()).isEqualTo(4);
    }

    @Test
    void orderIntegerCountEmptyTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        assertThat(testList.count()).isEqualTo(0);
    }

    @Test
    void orderIntegerDeleteTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        testList.delete(5);

        assertThat(testList.count()).isEqualTo(3);
    }

    @Test
    void orderIntegerClearTest() {
        OrderedList<Integer> testList = new OrderedList<>(true);

        testList.add(5);
        testList.add(17);
        testList.add(2);
        testList.add(10);

        testList.clear(true);

        assertThat(testList.count()).isEqualTo(0);
    }

    @Test
    void orderStringTest() {
        OrderedList<String> testList = new OrderedList<>(true);

        testList.add("B");
        testList.add("E");
        testList.add("A");
        testList.add("Z");

        assertThat(testList.tail.value).isEqualTo("Z");
    }
}
