package egor.lessons.lesson6;

public class PalindromeFinder {

    public static boolean isPalindrome(String testString) {
        if (testString.isBlank() || testString.length() == 1) {
            return false;
        }

        char[] charArray = testString.toCharArray();
        Deque<Character> deque = new Deque<>();

        for (int i = 0; i < charArray.length; i++) {
            deque.addTail(charArray[i]);
        }

        int counter =  charArray.length / 2;

        for (int i = 0; i< counter; i++) {
            if (deque.removeTail() != deque.removeFront())
                return false;
        }

        return true;
    }
}
