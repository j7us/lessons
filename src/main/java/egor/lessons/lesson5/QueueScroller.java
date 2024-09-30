package egor.lessons.lesson5;

public class QueueScroller {

    public static <T> void scrollQueue(Queue<T> test, int scroll) {
        if (test.size() == 0 || scroll == 0) {
            return;
        }

        for (int i = 0; i < scroll; i++) {
            T dequeue = test.dequeue();
            test.enqueue(dequeue);
        }
    }
}
