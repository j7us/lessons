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

        list.addInTail(new Node(-12560));
        list.addInTail(new Node(13));
        list.addInTail(new Node(13));
        list.addInTail(new Node(548000));
        list.addInTail(new Node(-1000));
        list.addInTail(new Node(0));

        LinkedList2Sorter.sort(list);

        assertThat(list.head.value).isEqualTo(-12560);
    }
}
