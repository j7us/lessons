package egor.lessons.lesson2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedList2SorterTest {

    @Test
    void sortEmptyTest() {
        LinkedList2 list = new LinkedList2();

        LinkedList2Sorter.sort(list);

        assertThat(list.head).isNull();
    }

    @Test
    void sortTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(11));
        list.addInTail(new Node(10));
        list.addInTail(new Node(9));
        list.addInTail(new Node(8));
        list.addInTail(new Node(7));
        list.addInTail(new Node(6));
        list.addInTail(new Node(5));

        LinkedList2Sorter.sort(list);

        assertThat(list.head.value).isEqualTo(3);
    }
}
