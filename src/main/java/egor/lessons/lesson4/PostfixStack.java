package egor.lessons.lesson4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class PostfixStack {

    public static int calculatePostfix(Stack<String> stack) {
        Stack<Integer> intStack = new Stack<>();
        boolean isEqualsChar = false;
        Map<String, BiFunction<Integer, Integer, Integer>> operations= new HashMap<>();
        operations.put("+", (a,b) -> a + b);
        operations.put("-", (a,b) -> a - b);
        operations.put("*", (a,b) -> a * b);
        operations.put("/", (a,b) -> a / b);

        for (String i = stack.pop(); i != null && !isEqualsChar; i = stack.pop()) {
            Integer first = intStack.pop();
            Integer second = intStack.pop();

            switch (i) {
                case "+", "-", "*", "/" -> intStack.push(operations.get(i).apply(first, second));
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
