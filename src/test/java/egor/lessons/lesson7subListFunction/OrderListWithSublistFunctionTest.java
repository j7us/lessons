package egor.lessons.lesson7subListFunction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderListWithSublistFunctionTest {

    @Test
    void subListTest() {
        OrderListWithSublistFunction<Integer> list = new OrderListWithSublistFunction<>(false);
         list.add(7);
         list.add(7);
         list.add(7);
         list.add(7);
         list.add(9);
         list.add(17);
         list.add(5);
         list.add(1);
         list.add(0);

        OrderListWithSublistFunction<Integer> subList = new OrderListWithSublistFunction<>(false);
        subList.add(7);
        subList.add(7);
        subList.add(9);
        subList.add(17);

        boolean res = list.isSubListExists(subList);

        assertThat(res).isTrue();
    }
}
