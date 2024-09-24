package egor.lessons.lesson4;

public class ParenthesesWithStack {

    public static boolean isCorrect(String parentheses) {
        Stack<Character> stack = new Stack<>();

        char[] charArray = parentheses.toCharArray();

        for (Character ch : charArray) {
            if (ch == '(') {
                stack.push(ch);
            } else if (stack.pop() == null) {
                return false;
            }
        }

        return stack.pop() == null;
    }
}
