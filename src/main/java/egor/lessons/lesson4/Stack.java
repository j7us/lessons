package egor.lessons.lesson4;
import java.util.*;

public class Stack<T>
{

    private ArrayList<T> list;
    public Stack()
    {
        list = new ArrayList<>();
    }

    public int size()
    {
        return list.size();
    }

    public T pop()
    {
        return list.isEmpty()
                ? null
                : list.remove(list.size() - 1);
    }

    public void push(T val)
    {
        list.add(val);
    }

    public T peek()
    {
        return list.isEmpty()
                ? null
                : list.get(list.size() - 1);
    }
}
