package egor.lessons.lesson2;

public class LinkedList2Inverter {

    public static void invertList(LinkedList2 list) {
        if (list.count() == 0 || list.count() == 1) {
            return;
        }

        Node node = list.head;

        for (int i = 0; i<list.count(); i++) {
            Node next = node.next;
            node.next = node.prev;
            node.prev = next;
            node = node.prev;
        }

        Node head = list.head;
        list.head = list.tail;
        list.tail = head;
    }
}
