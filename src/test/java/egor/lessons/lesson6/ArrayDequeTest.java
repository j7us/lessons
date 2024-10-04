package egor.lessons.lesson6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayDequeTest {

    @Test
    void dequeTest() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.removeFront();

        String s = deque.removeTail();

        assertThat(s).isNull();
    }

    @Test
    void addTest() {
        ArrayDeque<String> deque = new ArrayDeque<>();

        deque.addFront("1");
        deque.addFront("2");
        deque.addTail("3");
        deque.addTail("4");

        String res = deque.removeFront();
        assertThat(res).isEqualTo("2");
    }
}
