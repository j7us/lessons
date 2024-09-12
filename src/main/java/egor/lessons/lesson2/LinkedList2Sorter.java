package egor.lessons.lesson2;

public class LinkedList2Sorter {

    public static void sort(LinkedList2 list) {
        if (list.count() == 0 || list.count() == 1) {
            return;
        }

        Node current = list.head;
        Node compared;

        for (int i = 0; i < list.count()-1; i++) {
            compared = current.next;

            for (int x = i + 1; x < list.count(); x++) {

                if (compared.value < current.value) {
                    Node comparedPrev = compared.prev;
                    compared.prev = current.prev;
                    current.prev = comparedPrev;

                    Node comparedNext = compared.next;
                    compared.next = current.next;
                    current.next = comparedNext;

                    if (compared.next == compared) {
                        compared.next = current;
                        current.prev = compared;
                    }

                    if (current == list.head) {
                        list.head = compared;
                    } else {
                        compared.prev.next = compared;
                    }

                    compared.next.prev = compared;

                    if (compared == list.tail) {
                        list.tail = current;
                    } else {
                        current.next.prev = current;
                    }

                    current.prev.next = current;

                    current = compared;
                    break;
                }

                compared = compared.next;
            }

            current = current.next;
        }
    }
}
