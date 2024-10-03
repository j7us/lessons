package egor.lessons.lesson6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DequeWithMinFunctionTest {

    @Test
    void minTest() {
        DequeWithMinFunction deque = new DequeWithMinFunction();

        deque.addFront(17);
        deque.addFront(1);
        deque.addTail(2);
        deque.addFront(-10);
        deque.addFront(7);
        deque.addTail(1);
        deque.addTail(11);

        Integer res = deque.getMin();

        assertThat(res).isEqualTo(-10);
    }
}
