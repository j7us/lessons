package egor.lessons.lesson5;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CyclicQueue<T> {
    private T[] array;
    private int count;
    private int capacity;
    private int firstIndx = -1;
    private int lastIndx = -1;

    public CyclicQueue(Class clz, int capacity) {
        array = (T[]) Array.newInstance(clz, capacity);
        this.capacity = capacity;
    }

    public void enqueue(T item) {
        if (count == capacity) {
            return;
        }

        if (firstIndx == -1) {
            firstIndx = 0;
            lastIndx = 0;
            array[firstIndx] = item;
            count++;
            return;
        }

        lastIndx = getNextIndx(lastIndx);
        array[lastIndx] = item;
        count++;
    }

    private int getNextIndx(int currentIndx) {
        if (currentIndx == capacity - 1) {
            return 0;
        }

        return currentIndx + 1;
    }

    public T dequeue() {
        if (count == 0) {
            return null;
        }

        T res = array[firstIndx];
        array[firstIndx] = null;

        int newFirstIndex = getNextIndx(firstIndx);

        if (array[newFirstIndex] != null) {
            firstIndx = newFirstIndex;
        }

        count--;
        return res;
    }

    public int size()
    {
        return count;
    }
}
