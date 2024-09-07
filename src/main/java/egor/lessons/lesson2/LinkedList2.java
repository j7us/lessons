package egor.lessons.lesson2;
import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;
    private int count;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        count++;
    }

    public Node find(int value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int value)
    {
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
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                connectNodeNeighbors(currentNode);
                count--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private void connectNodeNeighbors(Node currentNode) {
        Node preNode = currentNode.prev;
        if (preNode == null) {
            this.head = currentNode.next;
        } else {
            preNode.next = currentNode.next;
        }

        Node nextNode = currentNode.next;
        if (nextNode == null) {
            this.tail = currentNode.prev;
        } else {
            nextNode.prev = currentNode.prev;
        }
    }

    public void removeAll(int value)
    {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                connectNodeNeighbors(currentNode);
                count--;
            }
            currentNode = currentNode.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
        count = 0;
    }

    public int count()
    {
        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert)
    {
        if (nodeAfter == null) {
            nodeToInsert.prev = null;
            nodeToInsert.next = this.head;

            Node prevHead = this.head;
            this.head = nodeToInsert;

            count++;
            if (prevHead == null) {
                this.tail = nodeToInsert;
                return;
            }

            prevHead.prev = nodeToInsert;
            return;
        }

        Node node = this.head;

        while(node != null) {
            if (node == nodeAfter) {
                nodeToInsert.prev = node;

                Node nextForInsert = node.next;
                nodeToInsert.next = nextForInsert;
                node.next = nodeToInsert;

                if (this.tail == node) {
                    this.tail = nodeToInsert;
                } else {
                    nextForInsert.prev = nodeToInsert;
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
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
