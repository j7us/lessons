package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AvgInStackTest {

    @Test
    void avgTest() {
        Stack<Integer> testStack = new Stack<>();
        testStack.push(4);
        testStack.push(2);
        testStack.push(2);
        testStack.push(2);

        double avg = AvgInStack.avg(testStack);

        assertThat(avg).isEqualTo(2.5);
    }
}
