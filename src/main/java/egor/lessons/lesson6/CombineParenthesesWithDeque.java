package egor.lessons.lesson6;

import java.util.HashMap;
import java.util.Map;

public class CombineParenthesesWithDeque {

    public static boolean isCorrect(String parentheses) {
        Map<Character, Character> parenthesesCombo = new HashMap<>();
        Deque<Character> deque = new Deque<>();

        parenthesesCombo.put('}', '{');
        parenthesesCombo.put(']', '[');
        parenthesesCombo.put(')', '(');


        for (Character ch : parentheses.toCharArray()) {
            if (!parenthesesCombo.containsKey(ch)) {
                deque.addTail(ch);
                continue;
            }

            Character tail = deque.removeTail();

            if (tail == null || tail != parenthesesCombo.get(ch)) {
                return false;
            }
        }

        return deque.removeTail() == null;
    }
}
