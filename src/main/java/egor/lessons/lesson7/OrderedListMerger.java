package egor.lessons.lesson7;

import java.util.function.BiFunction;

public class OrderedListMerger {

    public static <T> OrderedList<T> mergeList(OrderedList<T> firstList,
                                               OrderedList<T> secondList,
                                               boolean isListAscending) {
        Node<T> first = firstList.head;
        Node<T> second = secondList.head;

        BiFunction<T, T, Integer> nodePriorityFunction = getPriorityByAscending(isListAscending);

        OrderedList<T> resultList = new OrderedList<>(isListAscending);

        for (; first != null && second != null;) {
            Integer compareRes = nodePriorityFunction.apply(first.value, second.value);

            if (compareRes < 0) {
                resultList.add(first.value);
                first = first.next;
            } else if (compareRes > 0) {
                resultList.add(second.value);
                second = second.next;
            } else {
                resultList.add(first.value);
                resultList.add(second.value);
                first = first.next;
                second = second.next;
            }
        }

        if (first != null || second != null) {
            addRemainingNodes(resultList, first == null ? second : first);
        }

        return resultList;
    }

    private static <T> BiFunction<T, T, Integer> getPriorityByAscending(boolean isListAscending) {
        if (isListAscending) {
            return OrderedListMerger::compare;
        }

        return (T v1,T v2) -> compare(v1, v2) * -1;
    }

    private static <T> int compare(T v1, T v2) {
        if (v1 instanceof Integer) {
            return (int) v1 - (int) v2;
        }

        return ((String) v1).compareTo((String) v2);
    }


    private static <T> void addRemainingNodes(OrderedList<T> resultList, Node<T> nodeForRemaining) {
        for (Node<T> node = nodeForRemaining; node != null; node = node.next) {
            resultList.add(node.value);
        }
    }
}
