package egor.lessons.lesson5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueWithStackTest {

    @Test
    void queueTest() {
        QueueWithStack<String> testQueue = new QueueWithStack<>();

        testQueue.enqueue("A");
        testQueue.enqueue("B");
        testQueue.enqueue("C");

        testQueue.dequeue();

        assertThat(testQueue.dequeue()).isEqualTo("B");
    }

    @Test
    void queueReverseStackTest() {
        QueueWithStack<String> testQueue = new QueueWithStack<>();

        testQueue.enqueue("A");
        testQueue.enqueue("B");
        testQueue.enqueue("C");

        testQueue.dequeue();

        testQueue.enqueue("EEE");

        testQueue.dequeue();
        testQueue.dequeue();


        assertThat(testQueue.dequeue()).isEqualTo("EEE");
    }
}
