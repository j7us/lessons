package egor.lessons.lesson5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CyclicQueueTest {

    @Test
    void queueTest() {
        CyclicQueue<String> testQueue = new CyclicQueue<>(String.class, 3);

        testQueue.enqueue("A");
        testQueue.enqueue("B");
        testQueue.enqueue("C");

        testQueue.dequeue();

        testQueue.enqueue("D");

        assertThat(testQueue.dequeue()).isEqualTo("B");
    }
}
