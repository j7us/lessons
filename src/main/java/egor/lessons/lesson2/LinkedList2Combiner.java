package egor.lessons.lesson2;

public class LinkedList2Combiner {

    public static LinkedList2 combine(LinkedList2 first, LinkedList2 second) {
        sort(first);
        sort(second);

        LinkedList2 resultList = new LinkedList2();

        Node firstNode = first.head;
        Node secondNode = second.head;

        for(int i = 0; firstNode != null && secondNode != null; i++) {
            if (firstNode.value < secondNode.value) {
                resultList.addInTail(new Node(firstNode.value));
                firstNode = firstNode.next;
            } else if (secondNode.value < firstNode.value) {
                resultList.addInTail(new Node(secondNode.value));
                secondNode = secondNode.next;
            } else {
                resultList.addInTail(new Node(firstNode.value));
                resultList.addInTail(new Node(secondNode.value));
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }
        }

        if (secondNode != null) {
            addAll(secondNode, resultList);
        } else if (firstNode != null) {
            addAll(firstNode, resultList);
        }

        return resultList;
    }

    private static void addAll(Node from, LinkedList2 to) {
        Node addedNode = from;
        for (int i = 0; addedNode != null; i++) {
            to.addInTail(new Node(addedNode.value));
            addedNode = addedNode.next;
        }
    }

    private static void sort(LinkedList2 list) {
        if (list.count() == 0 || list.count() == 1) {
            return;
        }

        for (Node current = list.head; current != null; current = current.next) {
            for (Node prev = current.prev; prev != null; prev = prev.prev) {
                if (current.value < prev.value) {
                    swapNodes(prev, current, list);
                    prev = current;
                } else {
                    break;
                }
            }
        }
    }

    private static void swapNodes(Node prev, Node current, LinkedList2 list) {
        prev.next = current.next;
        Node prevForCurrent = prev.prev;
        prev.prev = current;
        current.next = prev;
        current.prev = prevForCurrent;

        if (list.head != prev) {
            prevForCurrent.next = current;
        } else {
            list.head = current;
        }

        if (list.tail != current) {
            prev.next.prev = prev;
        } else {
            list.tail = prev;
        }
    }
}
