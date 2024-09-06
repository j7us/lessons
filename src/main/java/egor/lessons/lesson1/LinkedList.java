package egor.lessons.lesson1;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    private int count;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        count++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int value)
    {
        Node node = this.head;

        if (node == null) {
            return false;
        }

        if (node.value == value) {
            if (this.head == this.tail) {
                this.tail = null;
            }

            this.head = node.next;

            count--;
            return true;
        }

        while(node.next != null) {
            if (node.next.value == value) {
                Node removingNode = node.next;
                node.next = removingNode.next;

                if (node.next == null) {
                    this.tail = node;
                }
                count--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int value)
    {
        Node node = this.head;

        if (node == null) {
            return;
        }

        while (node.next != null) {
            if (node.next.value == value) {
                Node removingNode = node.next;
                node.next = removingNode.next;

                if (node.next == null) {
                    this.tail = node;
                }

                count--;
                continue;
            }
            node = node.next;
        }

        if (this.head.value == value) {
            Node previousHead = this.head;
            this.head = this.head.next;

            if (this.tail == previousHead) {
                this.tail = null;
            }

            count--;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
        count = 0;
    }

    public int count()
    {
        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert)
    {
        if (nodeAfter == null) {
            nodeToInsert.next = this.head;

            if (this.tail == null) {
                this.tail = nodeToInsert;
            }

            this.head = nodeToInsert;
            count++;
            return;
        }

        Node node = this.head;

        while (node != null) {
            if (node == nodeAfter) {
                nodeToInsert.next = node.next;
                node.next = nodeToInsert;

                if (node == this.tail) {
                    this.tail = nodeToInsert;
                }

                count++;
                return;
            }

            node = node.next;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
