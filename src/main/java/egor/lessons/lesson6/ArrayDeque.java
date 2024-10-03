package egor.lessons.lesson6;

import java.util.ArrayList;

public class ArrayDeque<T> {
    ArrayList<T> list;
    int count;

    public ArrayDeque() {
        list = new ArrayList<>();
    }

    public void addFront(T item) {
        list.add(0, item);
        count++;
    }

    public void addTail(T item)
    {
        list.add(item);
        count++;
    }

    public T removeFront()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return list.remove(0);
    }

    public T removeTail()
    {
        if (count == 0) {
            return null;
        }
        count--;
        return list.remove(list.size() - 1);
    }

    public int size()
    {
        return count;
    }
}
