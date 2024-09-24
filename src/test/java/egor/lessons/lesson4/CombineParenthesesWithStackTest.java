package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombineParenthesesWithStackTest {

    @Test
    void isCorrectFalseTest() {
        String testStr = "{{{}[[]]]";

        boolean res = CombineParenthesesWithStack.isCorrect(testStr);

        assertThat(res).isFalse();
    }

    @Test
    void isCorrectTrueTest() {
        String testStr = "{{{()[]}}[]()}";

        boolean res = CombineParenthesesWithStack.isCorrect(testStr);

        assertThat(res).isTrue();
    }

    @Test
    void isCorrectWithOneTypeTest() {
        String testStr = "}}}}]))]";

        boolean res = CombineParenthesesWithStack.isCorrect(testStr);

        assertThat(res).isFalse();
    }
}
