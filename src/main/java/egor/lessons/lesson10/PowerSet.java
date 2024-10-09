package egor.lessons.lesson10;

import java.util.HashMap;
import java.util.Set;

public class PowerSet
{
    private HashMap<String, Object> map;
    private int count;

    public PowerSet()
    {
        map = new HashMap<>(20000);
    }

    public int size()
    {
        return count;
    }


    public void put(String value)
    {
        if (!map.containsKey(value)) {
            map.put(value, new Object());
            count++;
        }
    }

    public boolean get(String value)
    {
        return map.containsKey(value);
    }

    public boolean remove(String value)
    {
        count--;
        return map.remove(value) != null;
    }

    public PowerSet intersection(PowerSet set2)
    {
        if (count == 0) {
            return new PowerSet();
        }

        Set<String> keys = map.keySet();
        PowerSet resultSet = new PowerSet();

        keys.forEach(key -> {
            if (set2.get(key)) {
                resultSet.put(key);
            }
        });

        return resultSet;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet resultSet = new PowerSet();

        set2.map.keySet().forEach(resultSet::put);
        map.keySet().forEach(resultSet::put);

        return resultSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet resultSet = new PowerSet();

        if (count == 0) {
            set2.map.keySet().forEach(resultSet::put);
        } else {
            map.keySet().forEach(k -> {
                if (!set2.get(k)) {
                    resultSet.put(k);
                }
            });
        }

        return resultSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        if (count == 0) {
            return false;
        }

        Set<String> keys = set2.map.keySet();

        for (String key : keys) {
            if (!map.containsKey(key)) {
                return false;
            }
        }

        return true;
    }

    public boolean equals(PowerSet set2)
    {
        return count == set2.size() && isSubset(set2);
    }

}
