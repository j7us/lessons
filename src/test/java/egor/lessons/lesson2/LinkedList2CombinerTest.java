package egor.lessons.lesson2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedList2CombinerTest {

    @Test
    void combinerTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(7));
        list.addInTail(new Node(0));
        list.addInTail(new Node(15));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.addInTail(new Node(6));
        list.addInTail(new Node(9));
        list.addInTail(new Node(12));

        LinkedList2 list2 = new LinkedList2();

        list2.addInTail(new Node(3));
        list2.addInTail(new Node(4));
        list2.addInTail(new Node(-100));

        LinkedList2 res = LinkedList2Combiner.combine(list, list2);

        assertThat(res.head.value).isEqualTo(-100);
    }
}
