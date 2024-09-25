package egor.lessons.lesson4;

public class PostfixStack {

    public static int calculatePostfix(Stack<String> stack) {
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
                case "=" -> {isEqualsChar = true;
                             if (first != null) {
                                intStack.push(first);
                             }}
                default -> {intStack.push(Integer.valueOf(i));
                            if (first != null) {
                                intStack.push(first);
                            }}
            }
        }

        return intStack.size() != 0
                ? intStack.pop()
                : 0;
    }
}
