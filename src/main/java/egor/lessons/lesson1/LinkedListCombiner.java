package egor.lessons.lesson1;

public class LinkedListCombiner {

    public static LinkedList sumLinkedListValues(LinkedList first, LinkedList second) {
        Node firstNode = first.head;
        Node secondNode = second.head;

        LinkedList resultList = new LinkedList();

        while (firstNode != null && secondNode != null) {
            resultList.addInTail(new Node(firstNode.value + secondNode.value));
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        if ((firstNode == null && secondNode != null)
                ||(firstNode != null && secondNode == null)) {
            return new LinkedList();
        }

        return resultList;
    }
}
