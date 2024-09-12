package egor.lessons.lesson2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedList2NodeLoopInspectorTest {

    @Test
    void loopEmptyListTest() {
        LinkedList2 list = new LinkedList2();

        boolean res = LinkedList2NodeLoopInspector.isAnyLoopInList(list);

        assertThat(res).isFalse();
    }

    @Test
    void loopTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        Node testNode = list.tail.prev;

        testNode.next = list.tail;

        boolean res = LinkedList2NodeLoopInspector.isAnyLoopInList(list);

        assertThat(res).isTrue();
    }
}
