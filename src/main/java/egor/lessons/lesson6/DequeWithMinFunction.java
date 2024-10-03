package egor.lessons.lesson6;

import java.util.*;

import java.util.LinkedList;

public class DequeWithMinFunction {
    LinkedList<Integer> list;
    SortedMap<Integer, Object> min;
    int count;

    public DequeWithMinFunction()
    {
        list = new LinkedList<>();
        min = new TreeMap<>();
    }

    public void addFront(Integer item)
    {
        list.addFirst(item);
        count++;
        min.put(item, new Object());
    }

    public void addTail(Integer item)
    {
        list.addLast(item);
        count++;
        min.put(item, new Object());
    }

    public Integer removeFront()
    {
        if (count == 0) {
            return null;
        }

        Integer removed = list.removeFirst();
        min.remove(removed);
        count--;
        return removed;
    }

    public Integer removeTail()
    {
        if (count == 0) {
            return null;
        }

        Integer removed = list.removeLast();
        min.remove(removed);
        count--;
        return removed;
    }

    public int size()
    {
        return count;
    }

    public Integer getMin() {
        return min.isEmpty()
                ? null
                : min.firstKey();
    }
}
