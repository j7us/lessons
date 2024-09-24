package egor.lessons.lesson4;

public class MinimumInStackFinder {

    public static int findMin(Stack<Integer> stack) {
        Stack<Integer> secondStack = new Stack<>();
        secondStack.push(stack.pop());

        for (Integer i = stack.pop(); i != null; i = stack.pop()) {
            if (i < secondStack.peek()) {
                secondStack.push(i);
            }
        }

        return secondStack.peek();
    }
}
