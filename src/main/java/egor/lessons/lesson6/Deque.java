package egor.lessons.lesson6;

import java.util.*;

public class Deque<T>
{
    LinkedList<T> list;
    int count;

    public Deque()
    {
        list = new LinkedList<>();
    }

    public void addFront(T item)
    {
        list.addFirst(item);
        count++;
    }

    public void addTail(T item)
    {
        list.addLast(item);
        count++;
    }

    public T removeFront()
    {
        count--;
        return list.removeFirst();
    }

    public T removeTail()
    {
        count--;
        return list.removeLast();
    }

    public int size()
    {
        return count;
    }
}
