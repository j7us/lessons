package egor.lessons.lesson5;
import java.util.*;

public class Queue<T>
{

    private ArrayList<T> list;
    private int count;

    public Queue()
    {
        list = new ArrayList<>(16);
        count = 0;
    }

    public void enqueue(T item)
    {
        list.add(0, item);
        count++;
    }

    public T dequeue()
    {
        if (count != 0) {
            T remove = list.remove(count - 1);
            count--;
            return remove;
        }

        return null;
    }

    public int size()
    {
        return count;
    }

}
