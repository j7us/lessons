package egor.lessons.lesson9;

import java.lang.reflect.Array;

public class BinaryDictionary<T> {

    public int size;
    private int step;
    public Long [] slots;
    public T [] values;

    public BinaryDictionary(int sz, Class clazz)
    {
        size = sz;
        step = 3;
        slots = new Long[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(long hashKey)
    {
        int ind = (int) (hashKey % size);

        return ind < 0
                ? ind * -1
                : ind;
    }

    private long hash(String key) {
        long h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (h * 999983 + (long) key.charAt(i)) % 999999937;
        }

        return h;
    }

    private int seekSlot(String key) {
        long h = hash(key);
        int indx = hashFun(h);

        if (slots[indx] == null || (slots[indx] ^ h) == 0) {
            return indx;
        }

        for (int i = indx + step; i < size + indx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == null || (slots[indx] ^ h) == 0) {
                return a;
            }
        }

        return -1;
    }

    public boolean isKey(String key)
    {
        T value = get(key);

        return value != null;
    }

    public void put(String key, T value)
    {
        int indx = seekSlot(key);

        if (indx < 0) {
            return;
        }

        slots[indx] = hash(key);
        values[indx] = value;
    }

    public T get(String key)
    {
        long h = hash(key);
        int testIndx = hashFun(h);

        if (slots[testIndx] != null && (slots[testIndx] ^ h) == 0) {
            return values[testIndx];
        }

        for (int i = testIndx + step; i < size + testIndx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] != null && (slots[a] ^ h) == 0) {
                return values[a];
            }
        }

        return null;
    }
}
