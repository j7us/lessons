package egor.lessons.lesson4;

public class PostfixStack {

    public static int calculatePrefix(Stack<String> stack) {
        Stack<Integer> intStack = new Stack<>();
        boolean isEqualsChar = false;

        for (String i = stack.pop(); i != null && !isEqualsChar; i = stack.pop()) {
            Integer first = intStack.pop();
            Integer second = intStack.pop();

            switch (i) {
                case "+" -> intStack.push(first + second);
                case "-" -> intStack.push(first - second);
                case "*" -> intStack.push(first * second);
                case "/" -> intStack.push(first / second);
                case "=" -> isEqualsChar = true;
                default -> intStack.push(Integer.valueOf(i));
            }
        }

        return intStack.size() != 0
                ? intStack.pop()
                : 0;
    }
}
