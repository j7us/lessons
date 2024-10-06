package egor.lessons.lesson7subListFunction;

import egor.lessons.lesson7.OrderedList;

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

public class OrderListWithSublistFunction<T> {
    public Node<T> head, tail;
    private int count;
    private boolean _ascending;

    public OrderListWithSublistFunction(boolean asc)
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
        Node<T> node = new Node<>(val);

        if (head == null || (compareNodeWithAsc(node, head) < 0)) {
            return null;
        }

        return findWithAsc(node, head);
    }

    private Node<T> findWithAsc(Node<T> val, Node<T> nodeFrom) {
        for (Node<T> currentNode = nodeFrom; currentNode != null; currentNode = currentNode.next) {
            int compare = compareNodeWithAsc(val, currentNode);

            if (compare < 0) {
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
        return count;
    }

    public boolean isSubListExists(OrderListWithSublistFunction<T> subList) {
        Node<T> subNode = subList.head;

        for (Node<T> node = find(subNode.value); node != null; node = findWithAsc(subNode, node.next)) {
            boolean res = isSubListExistsFromCurrentNode(node, subList);
            if (res) {
                return true;
            }
        }

        return false;
    }

    private boolean isSubListExistsFromCurrentNode(Node<T> node, OrderListWithSublistFunction<T> subList) {
        Node<T> current = node;
        Node<T> subNode = subList.head;

        for (; subNode != null && current != null; subNode = subNode.next, current = current.next) {
            if (compare(subNode.value, current.value) != 0) {
                return false;
            }
        }

        return subNode == null;
    }

    ArrayList<Node<T>> getAll()
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
