package egor.lessons.lesson9;

import java.util.Comparator;


public class SortedDictionary<T> {
    OrderedList<KeyValuePair<T>> slots;

    public SortedDictionary() {
        slots = new OrderedList<>(true, Comparator.comparing(KeyValuePair::getKey));
    }

    public boolean isKey(String key)
    {
        Node<KeyValuePair<T>> node = slots.find(new KeyValuePair<>(key, null));

        return node != null;
    }

    public void put(String key, T value)
    {
        KeyValuePair<T> insert = new KeyValuePair<>(key, null);
        Node<KeyValuePair<T>> node = slots.find(insert);

        if (node == null) {
            slots.add(new KeyValuePair<>(key, value));
            return;
        }

        node.getValue().setValue(value);
    }

    public T get(String key)
    {
        KeyValuePair<T> insert = new KeyValuePair<>(key, null);
        Node<KeyValuePair<T>> node = slots.find(insert);

        if (node == null) {
            return null;
        }

        return node.getValue().getValue();
    }

    static class KeyValuePair<T> {
        String key;
        T value;

        public KeyValuePair(String key, T value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
