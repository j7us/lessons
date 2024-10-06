package egor.lessons.lesson7;

public class OrderedListDuplicateRemover {

    public static <T> void removeDuplicate(OrderedList<T> list) {
        if (list.count() == 0 || list.count() == 1) {
            return;
        }

        for (Node<T> node = list.head; node.next != null;) {
            if (node.next.value == node.value) {
                node = node.next;
                list.delete(node.value);
                continue;
            }

            node = node.next;
        }
    }
}
