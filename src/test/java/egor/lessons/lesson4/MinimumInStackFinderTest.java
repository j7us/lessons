package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumInStackFinderTest {

    @Test
    void findMinTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(70);
        stack.push(92);
        stack.push(1);
        stack.push(15);
        stack.push(22);
        stack.push(-1000);

        int min = MinimumInStackFinder.findMin(stack);

        assertThat(min).isEqualTo(-1000);
    }
}
