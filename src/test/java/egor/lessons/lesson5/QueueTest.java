package egor.lessons.lesson5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {

    @Test
    void queueTest() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        for (int i = 0; i < 2; i++) {
            queue.dequeue();
        }

        String res = queue.dequeue();

        assertThat(res).isEqualTo("C");
    }

    @Test
    void queueEmptyTest() {
        Queue<String> queue = new Queue<>();

        for (int i = 0; i < 2; i++) {
            queue.dequeue();
        }

        String res = queue.dequeue();

        assertThat(res).isNull();
    }
}
