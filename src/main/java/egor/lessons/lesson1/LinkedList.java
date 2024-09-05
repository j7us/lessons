package egor.lessons.lesson1;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

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
        } else if (node.value == value) {
            this.head = node.next;
            return true;
        }

        while(node.next != null) {
            if (node.next.value == value) {
                Node removingNode = node.next;
                node.next = removingNode.next;

                if (removingNode.next == null) {
                    this.tail = node;
                }
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

        if (node.value == value) {
            this.head = node.next;

            if (this.tail == node) {
                this.tail = null;
                return;
            }

            node = node.next;
        }

        while (node.next != null) {
            if (node.next.value == value) {
                Node removingNode = node.next;
                node.next = removingNode.next;

                if (removingNode.next == null) {
                    this.tail = node;
                    return;
                }
            }
            node = node.next;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert)
    {
        if (nodeAfter == null) {
            nodeToInsert.next = this.head;

            if (this.tail == this.head) {
                this.tail = nodeToInsert;
            }

            this.head = nodeToInsert;
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
