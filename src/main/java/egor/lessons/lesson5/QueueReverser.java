package egor.lessons.lesson5;

import java.util.Stack;

public class QueueReverser {

    public static <T> void reverse(Queue<T> queue) {
        if (queue.size() == 0) {
            return;
        }

        Stack<T> reverserStack = new Stack<>();

        for (int i = 0; i < queue.size(); i++) {
            reverserStack.push(queue.dequeue());
        }

        for (int i = 0; i < reverserStack.size(); i++) {
            queue.enqueue(reverserStack.pop());
        }
    }
}
