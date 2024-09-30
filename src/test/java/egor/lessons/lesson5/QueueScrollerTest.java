package egor.lessons.lesson5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueScrollerTest {

    @Test
    void scrollTest() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        QueueScroller.scrollQueue(queue, 2);

        assertThat(queue.dequeue()).isEqualTo("C");
    }
}
