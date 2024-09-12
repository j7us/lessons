package egor.lessons.lesson2;

public class LinkedList2Combiner {

    public static LinkedList2 combine(LinkedList2 first, LinkedList2 second) {
        sort(first);
        sort(second);

        LinkedList2 resultList = new LinkedList2();

        Node firstNode = first.head;
        Node secondNode = second.head;

        for(int i = 0; firstNode != null || secondNode != null; i++) {
            if (firstNode.value < secondNode.value) {
                resultList.addInTail(firstNode);
                firstNode = firstNode.next;
                continue;
            }

            if (secondNode.value < firstNode.value) {
                resultList.addInTail(secondNode);
                secondNode = secondNode.next;
            }

            if (secondNode.value == firstNode.value) {
                resultList.addInTail(firstNode);
                resultList.addInTail(secondNode);
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }
        }

        if (firstNode == null && secondNode != null) {
            addAll(secondNode, resultList);
        } else if (secondNode == null && firstNode != null) {
            addAll(firstNode, resultList);
        }

        return resultList;
    }

    private static void addAll(Node from, LinkedList2 to) {
        Node addedNode = from;
        for (int i = 0; addedNode != null; i++) {
            to.addInTail(addedNode);
            addedNode = addedNode.next;
        }
    }

    private static void sort(LinkedList2 list) {
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
