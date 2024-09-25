package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixStackTest {

    @Test
    void calculatePostfixTest() {
        Stack<String> testStack = new Stack<>();
        testStack.push("=");
        testStack.push("+");
        testStack.push("9");
        testStack.push("*");
        testStack.push("5");
        testStack.push("+");
        testStack.push("2");
        testStack.push("8");

        int res = PostfixStack.calculatePostfix(testStack);

        assertThat(res).isEqualTo(59);
    }
}
