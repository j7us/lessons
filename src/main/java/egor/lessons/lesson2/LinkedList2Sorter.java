package egor.lessons.lesson2;

public class LinkedList2Sorter {

    public static void sort(LinkedList2 list) {
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
