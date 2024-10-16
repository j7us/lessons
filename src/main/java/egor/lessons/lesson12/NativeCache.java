package egor.lessons.lesson12;

import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        int ind = key.hashCode() % size;

        return ind < 0
                ? ind * -1
                : ind;
    }

    private int seekSlot(String key) {
        int indx = hashFun(key);

        if (slots[indx] == null || slots[indx].equals(key)) {
            return indx;
        }

        for (int i = indx + 1; i < size + indx - 1; i++) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == null || slots[a].equals(key)) {
                return a;
            }
        }

        return -1;
    }

    public void put(String key, T value)
    {
        int indx = seekSlot(key);

        if (indx < 0) {
            removeOlder();
            indx = seekSlot(key);
        }

        slots[indx] = key;
        values[indx] = value;
    }

    public T get(String key)
    {
        int testIndx = hashFun(key);

        if (slots[testIndx].equals(key)) {
            hits[testIndx] = hits[testIndx] + 1;
            return values[testIndx];
        }

        for (int i = testIndx + 1; i < size + testIndx - 1; i++) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a].equals(key)) {
                hits[testIndx] = hits[testIndx] + 1;
                return values[a];
            }
        }

        return null;
    }

    private void removeOlder() {
        int indx = 0;

        for (int i = 1; i < hits.length; i++) {
            if (hits[indx] > hits[i]) {
                indx = i;
            }
        }

        slots[indx] = null;
    }
}
