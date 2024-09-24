package egor.lessons.lesson4;

public class AvgInStack {

    public static double avg(Stack<Integer> stack) {
        int count = 0;
        double res = 0;

        for(Integer i = stack.pop(); i != null; i = stack.pop()) {
            res += i;
            count++;
        }

        return res/count;
    }
}
