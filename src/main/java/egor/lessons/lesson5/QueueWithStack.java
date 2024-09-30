package egor.lessons.lesson5;

import java.util.Stack;

public class QueueWithStack <T>{
    private Stack<T> head;
    private Stack<T> reverse;
    private int count;

    public QueueWithStack() {
        head = new Stack<>();
        reverse = new Stack<>();
    }

    public void enqueue(T item) {
        head.push(item);
        count++;
    }

    public T dequeue() {
        if (reverse.empty() && head.empty()) {
            return null;
        }

        if (reverse.empty()) {
            reverseHead();
        }

        count--;
        return reverse.pop();
    }

    private void reverseHead() {
        int size = head.size();

        for (int i = 0; i < size; i++) {
            reverse.push(head.pop());
        }
    }

    public int getCount() {
        return count;
    }
}
