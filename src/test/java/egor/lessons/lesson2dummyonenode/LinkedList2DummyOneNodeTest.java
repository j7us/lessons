package egor.lessons.lesson2dummyonenode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedList2DummyOneNodeTest {

    @Test
    void addInTailTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        list.addInTail(new Node(1));

        assertThat(list.getHead().value).isSameAs(list.getTail().value).isEqualTo(1);
    }

    @Test
    void findTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));

        Node node = list.find(0);

        assertThat(node).isNull();
    }

    @Test
    void findAllTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        list.addInTail(new Node(1));
        list.addInTail(new Node(0));
        list.addInTail(new Node(1));

        ArrayList<Node> all = list.findAll(0);

        assertThat(all).hasSize(1);
    }

    @Test
    void findAllEmptyTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        ArrayList<Node> all = list.findAll(0);

        assertThat(all).isEmpty();
    }

    @Test
    void removeTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        list.addInTail(new Node(1));
        list.addInTail(new Node(0));
        list.addInTail(new Node(1));

        list.remove(0);

        assertThat(list.count()).isEqualTo(2);
    }

    @Test
    void insertTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        Node test = new Node(2);

        list.addInTail(new Node(1));
        list.addInTail(test);
        list.addInTail(new Node(3));

        list.insertAfter(test, new Node(10000));

        Node res = list.getHead().next.next;

        assertThat(res.value).isEqualTo(10000);
    }

    @Test
    void dummyTest() {
        LinkedList2DummyOneNode list = new LinkedList2DummyOneNode();

        Node head = list.getHead();

        assertThat(head).isNull();
    }
}
