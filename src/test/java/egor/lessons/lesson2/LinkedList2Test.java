package egor.lessons.lesson2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedList2Test {

    @Test
    void removeEmptyTest() {
        LinkedList2 list = new LinkedList2();

        boolean res = list.remove(1);

        assertThat(res).isFalse();
    }

    @Test
    void removeOnlyOneTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));

        list.remove(1);

        assertThat(list.tail)
                .isSameAs(list.head)
                .isNull();
    }

    @Test
    void removeHeadTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        list.remove(1);

        assertThat(list.tail.value)
                .isEqualTo(3);
    }

    @Test
    void removeMiddleTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        list.remove(1);

        assertThat(list.tail.prev.value)
                .isEqualTo(2);
    }

    @Test
    void removeTailTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(1));

        list.remove(1);

        assertThat(list.tail.value)
                .isEqualTo(3);
    }

    @Test
    void removeDuplicateTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));

        list.remove(1);

        assertThat(list.tail.value)
                .isEqualTo(1);
    }

    @Test
    void removeAllEmptyTest() {
        LinkedList2 list = new LinkedList2();

        list.removeAll(1);

        assertThat(list.tail).isSameAs(list.head)
                .isNull();
    }

    @Test
    void removeAllOnlyOneTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));

        list.removeAll(1);

        assertThat(list.tail).isSameAs(list.head)
                .isNull();
    }

    @Test
    void removeAllDuplicateTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));

        list.removeAll(1);

        assertThat(list.count())
                .isEqualTo(3);
    }

    @Test
    void findTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        Node node = list.find(3);

        assertThat(node.value).isEqualTo(3);
    }

    @Test
    void findAllTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        ArrayList<Node> res = list.findAll(1);

        assertThat(res).hasSize(4);
    }

    @Test
    void clearTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        list.clear();

        assertThat(list.count()).isEqualTo(0);
    }

    @Test
    void clearHeadTailTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        list.clear();

        assertThat(list.head).isSameAs(list.tail).isNull();
    }

    @Test
    void countTest() {
        LinkedList2 list = new LinkedList2();

        Node node = new Node(2);

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(node);
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        list.insertAfter(node, new Node(10));

        list.remove(2);

        list.removeAll(3);

        list.find(1);

        list.findAll(1);

        list.insertAfter(null, new Node(1000));

        int count = list.count();

        assertThat(count).isEqualTo(6);
    }

    @Test
    void countEmptyTest() {
        LinkedList2 list = new LinkedList2();

        int count = list.count();

        assertThat(count).isEqualTo(0);
    }

    @Test
    void insertAfterEmptyTest() {
        LinkedList2 list = new LinkedList2();

        list.insertAfter(null, new Node(1));

        assertThat(list.count()).isEqualTo(1);
    }

    @Test
    void insertAfterInHeadOnlyOneTest() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(new Node(1));

        list.insertAfter(null, new Node(2));

        assertThat(list.count()).isEqualTo(2);
    }

    @Test
    void insertAfterMiddleTest() {
        LinkedList2 list = new LinkedList2();

        Node node = new Node(1);

        list.addInTail(node);
        list.addInTail(new Node(3));

        list.insertAfter(node, new Node(2));

        assertThat(list.count()).isEqualTo(3);
    }

    @Test
    void insertAfterTailTest() {
        LinkedList2 list = new LinkedList2();

        Node node = new Node(3);

        list.addInTail(new Node(1));
        list.addInTail(node);

        list.insertAfter(node, new Node(2));

        assertThat(list.count()).isEqualTo(3);
    }
}
