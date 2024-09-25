package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefixStackTest {

    @Test
    void calculatePrefixTest() {
        Stack<String> testStack = new Stack<>();
        testStack.push("=");
        testStack.push("+");
        testStack.push("9");
        testStack.push("*");
        testStack.push("5");
        testStack.push("+");
        testStack.push("2");
        testStack.push("8");

        int res = PostfixStack.calculatePrefix(testStack);

        assertThat(res).isEqualTo(59);
    }
}
