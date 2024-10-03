package egor.lessons.lesson6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombineParenthesesWithDequeTest {

    @Test
    void parenthesesTest() {
        String testStr = "{{{()[]}}[]()}";

        boolean res = CombineParenthesesWithDeque.isCorrect(testStr);

        assertThat(res).isTrue();
    }

    @Test
    void parenthesesFalseTest() {
        String testStr = "{{{}[[]]]";

        boolean res = CombineParenthesesWithDeque.isCorrect(testStr);

        assertThat(res).isFalse();
    }
}
