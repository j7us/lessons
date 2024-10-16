package egor.lessons.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Bag<T> {
    private HashMap<T, Integer> map;

    public Bag() {
        map = new HashMap<>();
    }

    public void put(T key) {
        if (map.containsKey(key)) {
            map.computeIfPresent(key, (a,b) ->  b + 1);
            return;
        }

        map.put(key, 1);
    }

    public boolean remove(T key) {
        if (!map.containsKey(key)) {
            return false;
        }

        map.computeIfPresent(key, (a,b) -> b - 1);

        if (map.get(key) == 0) {
            map.remove(key);
        }

        return true;
    }

    public Map<T, Integer> getALL() {
        return Map.copyOf(map);
    }
}
