package egor.lessons.lesson7;

import java.util.HashMap;
import java.util.Map;

public class OrderListValueCounter {

    public static <T> T getMaxCountValue(OrderedList<T> list) {
        HashMap<T, Integer> count = new HashMap<>();

        for (Node<T> node = list.head; node != null; node = node.next) {
            if (!count.containsKey(node.value)) {
                count.put(node.value, 1);
                continue;
            }

            count.computeIfPresent(node.value, (T key, Integer value) ->  value + 1);
        }

        return count.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();

    }
}
