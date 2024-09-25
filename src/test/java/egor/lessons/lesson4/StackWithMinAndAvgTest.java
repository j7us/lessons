package egor.lessons.lesson4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StackWithMinAndAvgTest {

    @Test
    void findMinTest() {
        StackWithMinAndAvg stack = new StackWithMinAndAvg();

        stack.push(-1);
        stack.push(35);
        stack.push(1);
        stack.push(172);
        stack.push(25);

        Integer min = stack.findMin();

        assertThat(min).isEqualTo(-1);
    }

    @Test
    void findMinWithPopTest() {
        StackWithMinAndAvg stack = new StackWithMinAndAvg();

        stack.push(-1);
        stack.push(35);
        stack.push(1);
        stack.push(172);
        stack.push(25);
        stack.push(-10001);
        stack.push(5);
        stack.push(-1000);

        stack.pop();
        stack.pop();
        stack.pop();

        Integer min = stack.findMin();

        assertThat(min).isEqualTo(-1);
    }

    @Test
    void findMinEmptyTest() {
        StackWithMinAndAvg stack = new StackWithMinAndAvg();

        Integer min = stack.findMin();

        assertThat(min).isNull();
    }

    @Test
    void avgTest() {
        StackWithMinAndAvg stack = new StackWithMinAndAvg();

        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(4);

        double avg = stack.avg();

        assertThat(avg).isEqualTo(2.5);
    }

    @Test
    void avgWithPopTest() {
        StackWithMinAndAvg stack = new StackWithMinAndAvg();

        stack.push(2);
        stack.push(2);
        stack.push(2);
        stack.push(4);
        stack.push(17);
        stack.push(1234);
        stack.push(123);

        stack.pop();
        stack.pop();
        stack.pop();

        double avg = stack.avg();

        assertThat(avg).isEqualTo(2.5);
    }
}
