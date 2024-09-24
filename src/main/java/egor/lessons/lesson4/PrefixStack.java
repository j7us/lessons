package egor.lessons.lesson4;

public class PrefixStack {

    public static int calculatePrefix(Stack<String> stack) {
        Stack<Integer> intStack = new Stack<>();

        for (String i = stack.pop(); i != null; i = stack.pop()) {
            if (i.equals("+")) {
                Integer first = intStack.pop();
                Integer second = intStack.pop();
                intStack.push(first + second);
            } else if (i.equals("-")) {
                Integer first = intStack.pop();
                Integer second = intStack.pop();
                intStack.push(first - second);
            } else if (i.equals("*")) {
                Integer first = intStack.pop();
                Integer second = intStack.pop();
                intStack.push(first * second);
            } else if (i.equals("/")) {
                Integer first = intStack.pop();
                Integer second = intStack.pop();
                intStack.push(first / second);
            } else if (i.equals("=")) {
                return intStack.pop();
            } else {
                intStack.push(Integer.valueOf(i));
            }
        }

        return 0;
    }
}
