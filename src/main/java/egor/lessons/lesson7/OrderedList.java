package egor.lessons.lesson7;

import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private int count;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer) {
            return (int) v1 - (int) v2;
        }

        return ((String) v1).compareTo((String) v2);
    }

    public void add(T value)
    {
        Node<T> nodeToInsert = new Node<>(value);

        if (head == null && tail == null) {
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
            count++;
            return;
        }

        if (compareNodeWithAsc(nodeToInsert, tail) > 0) {
            tail.next = nodeToInsert;
            nodeToInsert.prev = tail;
            this.tail = nodeToInsert;
            count++;
            return;
        }

        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
            if (compareNodeWithAsc(nodeToInsert, currentNode) <= 0) {
                Node prev = currentNode.prev;
                nodeToInsert.prev = prev;
                nodeToInsert.next = currentNode;
                currentNode.prev = nodeToInsert;

                if (head == currentNode) {
                    this.head = nodeToInsert;
                } else {
                    prev.next = nodeToInsert;
                }

                count++;
                return;
            }
        }
    }

    private int compareNodeWithAsc(Node<T> toInsert, Node<T> current) {
        if (_ascending) {
            return compare(toInsert.value, current.value);
        } else {
            return compare(toInsert.value, current.value) * -1;
        }
    }

    public Node<T> find(T val)
    {
        if (head == null
                || (_ascending && compare(val, head.value) < 0)
                || (!_ascending && compare(val, head.value) > 0)) {
            return null;
        }

        return _ascending
                ? findWithAsc(val)
                : findWithDesc(val);
    }

    private Node<T> findWithAsc(T val) {
        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
            int compare = compare(val, currentNode.value);

            if (compare < 0) {
                return null;
            } else if (compare == 0) {
                return currentNode;
            }
        }

        return null;
    }

    private Node<T> findWithDesc(T val) {
        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
            int compare = compare(val, currentNode.value);

            if (compare > 0) {
                return null;
            } else if (compare == 0) {
                return currentNode;
            }
        }

        return null;
    }

    public void delete(T val)
    {
        if (head == null) {
            return;
        }

        for (Node<T> currentNode = head; currentNode != null; currentNode = currentNode.next) {
            if (compare(currentNode.value, val) == 0) {
                removeNode(currentNode);
                count--;
                return;
            }
        }
    }

    private void removeNode(Node<T> currentNode) {
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

    public void clear(boolean asc)
    {
        _ascending = asc;
        count = 0;
        head = null;
        tail = null;
    }

    public int count()
    {
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
