package egor.lessons.lesson2dummy;

import java.util.*;

public class LinkedList2Dummy {
    private Node head;
    private Node tail;
    private int count;

    public LinkedList2Dummy() {
        this.head = new DummyNode();
        this.tail = new DummyNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addInTail(Node item)
    {
        Node currentFakeTail = this.tail.prev;

        item.prev = currentFakeTail;
        currentFakeTail.next = item;

        item.next = this.tail;
        this.tail.prev = item;

        count++;
    }

    public Node getHead() {
        return this.head.next.isDummy()
                ? null
                : this.head.next;
    }

    public Node getTail() {
        return this.tail.prev.isDummy()
                ? null
                : this.tail.prev;
    }

    public Node find(int _value)
    {
        Node node = this.head.next;
        for (int i = 0; i < count; i++) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head.next;
        for (int i = 0; i < count; i++) {
            if (node.value == _value)
                 nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head.next;
        for (int i = 0; i < count; i++) {
            if (node.value == _value) {
                connectNeighbors(node.prev, node.next);
                count--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    private void connectNeighbors(Node prev, Node next) {
        prev.next = next;
        next.prev = prev;
    }

    public void removeAll(int _value)
    {
        Node node = this.head.next;
        for (int i = 0; !node.isDummy(); i++) {
            if (node.value == _value) {
                connectNeighbors(node.prev, node.next);
                count--;
            }
            node = node.next;
        }
    }

    public void clear()
    {
       this.head.next = this.tail;
       this.tail.prev = this.head;
    }

    public int count()
    {
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            Node currentFakeHead = this.head.next;
            _nodeToInsert.next = currentFakeHead;
            currentFakeHead.prev = _nodeToInsert;
            this.head.next = _nodeToInsert;
            _nodeToInsert.prev = this.head;
            count++;
            return;
        }

        Node node = this.head.next;

        for (int i = 0; i < count; i++) {
            if (node == _nodeAfter) {
                Node nodeNext = node.next;
                _nodeToInsert.next = nodeNext;
                nodeNext.prev = _nodeToInsert;
                _nodeToInsert.prev = node;
                node.next = _nodeToInsert;
                count++;
                return;
            }
            node = node.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }

    public boolean isDummy() {
        return false;
    }
}

class DummyNode extends Node {

    public DummyNode() {
        super(0);
    }

    @Override
    public boolean isDummy() {
        return true;
    }
}


