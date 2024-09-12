package egor.lessons.lesson2;

public class LinkedList2NodeLoopInspector {

    public static boolean isAnyLoopInList(LinkedList2 list) {
        if (list.count() == 0) {
            return false;
        }

        Node fromHead = list.head;
        Node fromTail = list.tail;


        for(int i = 0; i < list.count(); i++) {
            fromHead = fromHead.next;
            fromTail = fromTail.prev;
        }

        return list.head.prev != null || list.tail.next != null || fromHead != list.tail || fromTail != list.head;
    }
}
