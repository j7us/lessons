package egor.lessons.lesson1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    void removeWithEmptyListTest() {
        LinkedList linkedList = new LinkedList();

        boolean result = linkedList.remove(1);

        assertThat(result).isFalse();
    }

    @Test
    void removeCompleteTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        boolean result = linkedList.remove(0);

       assertThat(result).isTrue();
    }

    @Test
    void tryToFindRemovedNodeTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.remove(0);

        assertThat(linkedList.find(0)).isNull();
    }
    
    @Test
    void removeHeadTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.remove(0);

        Node survivedNode = linkedList.find(1);

        assertThat(survivedNode)
                .isSameAs(linkedList.head)
                .isSameAs(linkedList.tail);
    }

    @Test
    void removeTailTest() {
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i<4; i++) {
            linkedList.addInTail(new Node(i));
        }

        linkedList.remove(3);
        Node tail = linkedList.tail;

        assertThat(tail.value).isEqualTo(2);
    }

    @Test
    void removeNotExistsNodeTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        boolean result = linkedList.remove(2);

        assertThat(result).isFalse();
    }

    @Test
    void removeOnlyElementTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));

        boolean result = linkedList.remove(0);
    }

    @Test
    void removeAllWithHeadTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.removeAll(0);

        int count = linkedList.count();

        assertThat(count).isEqualTo(2);
    }

    @Test
    void removeAllWithHeadAndTailTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));

        linkedList.removeAll(0);

        assertThat(linkedList.head.value)
                .isSameAs(linkedList.tail.value)
                .isEqualTo(1);
    }

    @Test
    void removeAllWhenOnlyOneNodeTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));

        linkedList.removeAll(0);

        assertThat(linkedList.head)
                .isSameAs(linkedList.tail)
                .isNull();
    }

    @Test
    void clearTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));

        linkedList.clear();

        assertThat(linkedList.count()).isEqualTo(0);
    }

    @Test
    void clearHeadAndTailTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));

        linkedList.clear();

        assertThat(linkedList.head)
                .isSameAs(linkedList.tail)
                .isNull();
    }

    @Test
    void finAllTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(3));

        ArrayList<Node> resultList = linkedList.findAll(1);

        assertThat(resultList).hasSize(2);
    }

    @Test
    void findAllFalseTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(3));

        ArrayList<Node> resultList = linkedList.findAll(10000);

        assertThat(resultList).isEmpty();
    }

    @Test
    void countTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));

        int listCount = linkedList.count();

        assertThat(listCount).isEqualTo(4);
    }

    @Test
    void emptyCountTest() {
        LinkedList linkedList = new LinkedList();

        int listCount = linkedList.count();

        assertThat(listCount).isEqualTo(0);
    }

    @Test
    void countOnlyOneNodeTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));

        int listCount = linkedList.count();

        assertThat(listCount).isEqualTo(1);
    }

    @Test
    void insertAfterTest() {
        LinkedList linkedList = new LinkedList();

        Node testNode = new Node(2);

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(testNode);
        linkedList.addInTail(new Node(3));

        linkedList.insertAfter(testNode, new Node(10000));

        Node result = linkedList.head;

        for (int i = 0; i<3; i++) {
            result = result.next;
        }

        assertThat(result.value).isEqualTo(10000);
    }

    @Test
    void insertAfterWithEmptyListTest() {
        LinkedList linkedList = new LinkedList();

        Node testNode = new Node(2);

        linkedList.insertAfter(null, testNode);

        assertThat(linkedList.head.value)
                .isSameAs(linkedList.tail.value)
                .isEqualTo(2);
    }

    @Test
    void insertAfterToHeadTest() {
        LinkedList linkedList = new LinkedList();

        Node testNode = new Node(2);

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.insertAfter(null, testNode);

        assertThat(linkedList.head.value).isEqualTo(2);
    }

    @Test
    void insertAfterToTailTest() {
        LinkedList linkedList = new LinkedList();

        Node testNode = new Node(2);
        Node afterNode = new Node(1);

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(afterNode);

        linkedList.insertAfter(afterNode, testNode);

        assertThat(linkedList.tail.value).isEqualTo(2);
    }
}
