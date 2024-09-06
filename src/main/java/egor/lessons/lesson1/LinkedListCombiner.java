package egor.lessons.lesson1;

public class LinkedListCombiner {

    public static LinkedList sumLinkedListValues(LinkedList first, LinkedList second) {
        LinkedList resultList = new LinkedList();

        if (first.count() != second.count()) {
            return resultList;
        }

        Node firstNode = first.head;
        Node secondNode = second.head;

        while (firstNode != null) {
            resultList.addInTail(new Node(firstNode.value + secondNode.value));
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return resultList;
    }
}
