package egor.lessons.lesson4;

import java.util.ArrayList;

public class StackWithMinAndAvg {

    private ArrayList<Integer> list;
    private Stack<Integer> minStack = new Stack<>();
    private double sum;
    public StackWithMinAndAvg()
    {
        list = new ArrayList<>();
    }

    public int size()
    {
        return list.size();
    }

    public Integer pop()
    {
        Integer result = list.isEmpty()
                ? null
                : list.remove(list.size() - 1);

        if (result != null) {
            sum -= result;
            if (minStack.peek().equals(result))
                minStack.pop();
        }

        return result;
    }

    public void push(Integer val)
    {
        list.add(val);
        sum+=val;

        if (minStack.peek() == null || val < minStack.peek()) {
            minStack.push(val);
        }
    }

    public Integer peek()
    {
        return list.isEmpty()
                ? null
                : list.get(list.size() - 1);
    }

    public Integer findMin() {
        return minStack.pop();
    }

    public double avg() {
        return list.isEmpty()
                ? 0
                : sum/list.size();
    }
}
