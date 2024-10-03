package egor.lessons.lesson1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListTest {

    @Test
    void removeWithEmptyListTest() {
        LinkedList linkedList = new LinkedList();

        boolean result = linkedList.remove(1);

        assertThat(result).isFalse();
    }

    @Test
    void removeWithOneNodeTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(1));

        boolean result = linkedList.remove(1);

        assertThat(result).isTrue();
    }

    @Test
    void removeWithOneNodeHeadTailTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(1));

        linkedList.remove(1);

        assertThat(linkedList.head)
                .isSameAs(linkedList.tail)
                .isNull();
    }

    @Test
    void removeTailToHeadTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.remove(1);

        assertThat(linkedList.tail.value)
                .isSameAs(linkedList.head.value)
                .isEqualTo(0);
    }

    @Test
    void removeHeadToTailTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));

        linkedList.remove(0);

        assertThat(linkedList.tail.value)
                .isSameAs(linkedList.head.value)
                .isEqualTo(1);
    }

    @Test
    void removeWithDuplicatesTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(0));

        linkedList.remove(0);

        assertThat(linkedList.count()).isEqualTo(3);
    }

    @Test
    void removeAllTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));

        linkedList.removeAll(0);

        assertThat(linkedList.count()).isEqualTo(1);
    }

    @Test
    void removeAllFalseTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));

        linkedList.removeAll(0);

        assertThat(linkedList.count()).isEqualTo(3);
    }

    @Test
    void clearTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(0));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(0));

        linkedList.clear();

        assertThat(linkedList.count()).isEqualTo(0);
    }

    @Test
    void findAllTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));

        ArrayList<Node> res = linkedList.findAll(2);

        assertThat(res).hasSize(1);
    }

    @Test
    void findAllEmptyListTest() {
        LinkedList linkedList = new LinkedList();

        ArrayList<Node> res = linkedList.findAll(2);

        assertThat(res).isEmpty();
    }

    @Test
    void countTest() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(3));

        linkedList.remove(1);

        linkedList.insertAfter(null, new Node(10));

        linkedList.removeAll(2);

        assertThat(linkedList.count()).isEqualTo(3);
    }

    @Test
    void insertAfterTest() {
        LinkedList linkedList = new LinkedList();

        Node first = new Node(1);
        Node second = new Node(2);

        linkedList.insertAfter(null, first);
        linkedList.insertAfter(first, second);

        assertThat(linkedList.tail.value).isEqualTo(2);
    }

    @Test
    void insertAfterWithDuplicates() {
        LinkedList linkedList = new LinkedList();

        Node first = new Node(1);
        Node second = new Node(2);

        linkedList.addInTail(first);
        linkedList.addInTail(new Node(1));
        linkedList.addInTail(new Node(2));
        linkedList.addInTail(new Node(3));

        linkedList.insertAfter(new Node(1), second);

        assertThat(linkedList.count()).isEqualTo(4);
    }

    @Test
    void sumListTest() {
        LinkedList first = new LinkedList();

        first.addInTail(new Node(1));
        first.addInTail(new Node(2));
        first.addInTail(new Node(3));

        LinkedList second = new LinkedList();

        LinkedList res = LinkedListCombiner.sumLinkedListValues(first, second);

        assertThat(res.head).isNull();
    }

    @Test
    void rand() {
        int[] ints = new int[10];


        System.out.println(ints.length);
    }
}
