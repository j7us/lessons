package egor.lessons.lesson4;

import java.util.HashMap;
import java.util.Map;

public class CombineParenthesesWithStack {

    public static boolean isCorrect(String parentheses) {
        Map<Character, Character> parenthesesCombo = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        parenthesesCombo.put('}', '{');
        parenthesesCombo.put(']', '[');
        parenthesesCombo.put(')', '(');

        for (Character ch : parentheses.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            Character pop = stack.pop();

            if (pop == null || pop != parenthesesCombo.get(ch)) {
                return false;
            }
        }

        return stack.pop() == null;
    }
}
