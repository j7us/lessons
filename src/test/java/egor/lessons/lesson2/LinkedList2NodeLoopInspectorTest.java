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

        Node node = new Node(2);
        Node nodeToTail = new Node(3);

        list.addInTail(new Node(1));
        list.addInTail(node);
        list.addInTail(nodeToTail);

        list.tail.next = list.head;

        boolean res = LinkedList2NodeLoopInspector.isAnyLoopInList(list);

        assertThat(res).isTrue();
    }
}
