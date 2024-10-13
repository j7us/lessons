package egor.lessons.lesson9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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

    public T getValue() {
        return value;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private ArrayList<Node<T>> array;
    private int count;
    HashMap<T, Integer> valueCounter;
    private boolean _ascending;
    Comparator<T> comparator;

    public OrderedList(boolean asc, Comparator<T> comparator)
    {
        this.comparator = comparator;
        head = null;
        tail = null;
        array = new ArrayList<>();
        valueCounter = new HashMap<>();
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        return comparator.compare(v1, v2);
    }

    public void add(T value)
    {
        Node<T> nodeToInsert = new Node<>(value);

        addToCounter(value);

        if (head == null && tail == null) {
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
            count++;
            array = getAll();
            return;
        }

        if (compareNodeWithAsc(nodeToInsert, tail) > 0) {
            tail.next = nodeToInsert;
            nodeToInsert.prev = tail;
            this.tail = nodeToInsert;
            count++;
            array = getAll();
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

                array = getAll();
                count++;
                return;
            }
        }
    }

    private void addToCounter(T val) {
        if (!valueCounter.containsKey(val)) {
            valueCounter.put(val, 1);
            return;
        }

        valueCounter.computeIfPresent(val, (T key, Integer value) ->  value + 1);
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
                array = getAll();
                valueCounter.computeIfPresent(currentNode.value, (T key, Integer value) ->  value - 1);
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
        array = new ArrayList<>();
        head = null;
        tail = null;
        valueCounter = new HashMap<>();
    }

    public int count()
    {
        return count;
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
    // Задание 8, удаление дубликатов.
    public void removeDuplicate() {
        if (count == 0 || count == 1) {
            return;
        }

        for (Node<T> node = head; node.next != null;) {
            if (node.next.value == node.value) {
                node = node.next;
                delete(node.value);
                continue;
            }

            node = node.next;
        }
    }

    //Задание 9, слияние списков.
    public void mergeList(OrderedList<T> mergedlist) {
         Node<T> current = head;
         Node<T> merged = mergedlist.head;

         for (;current != null && merged != null;) {
             int compareRes = compareNodeWithAsc(merged, current);

             if (compareRes <= 0) {
                 Node<T> toMerge = merged;
                 merged = merged.next;
                 insertNodeBefore(current, toMerge);
                 continue;
             }

             current = current.next;
         }

         if (merged != null) {
             addRemainingNodes(merged);
         }
    }

    private void insertNodeBefore(Node<T> beforeNode, Node<T> nodeToInsert) {
        Node<T> prev = beforeNode.prev;
        nodeToInsert.next = beforeNode;
        beforeNode.prev = nodeToInsert;
        nodeToInsert.prev = prev;

        if (nodeToInsert.prev == null) {
            head = nodeToInsert;
            return;
        }

        prev.next = nodeToInsert;
    }

    private void addRemainingNodes(Node<T> fromNode) {
        for (Node<T> node = fromNode; node != null; node = node.next) {
            add(node.value);
        }
    }

    //Задание 10, проверка под-списка.
    public boolean isSubListExists(OrderedList<T> subList) {
        Node<T> subNode = subList.head;

        for (Node<T> node = find(subNode.value); node != null; node = findWithAsc(subNode, node.next)) {
            boolean res = isSubListExistsFromCurrentNode(node, subList);
            if (res) {
                return true;
            }
        }

        return false;
    }

    private boolean isSubListExistsFromCurrentNode(Node<T> node, OrderedList<T> subList) {
        Node<T> current = node;
        Node<T> subNode = subList.head;

        for (; subNode != null && current != null; subNode = subNode.next, current = current.next) {
            if (compare(subNode.value, current.value) != 0) {
                return false;
            }
        }

        return subNode == null;
    }

    //Задание 11, нахождение самого часто встречающегося значения.
    public T getMaxCountValue() {
        return valueCounter.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

    //Задание 12, поиск индекса элемента.
    public int getIndexByValue(T val) {
        if (array.isEmpty()) {
            return -1;
        }

        Node<T> node = new Node<>(val);
        int minIndex = 0;
        int maxIndex = array.size() - 1;
        int ind = -1;

        for (; maxIndex >= minIndex;) {
            int midIndex = (maxIndex - minIndex) / 2;
            Node<T> midNode = array.get(midIndex);

            if (compareNodeWithAsc(midNode, node) == 0) {
                ind = midIndex;
                maxIndex = midIndex - 1;
            } else if (compareNodeWithAsc(midNode, node) < 0) {
                minIndex = midIndex + 1;
            } else {
                maxIndex = midIndex - 1;
            }
        }

        return ind;
    }
}
