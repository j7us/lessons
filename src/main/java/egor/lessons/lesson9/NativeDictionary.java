package egor.lessons.lesson9;
import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    private int step;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        step = 3;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        return key.hashCode() % size;
    }

    private int seekSlot(String key) {
        int indx = hashFun(key);

        if (slots[indx] == null || slots[indx].equals(key)) {
            return indx;
        }

        for (int i = indx + step; i < size + indx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == null || slots[a].equals(key)) {
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

        slots[indx] = key;
        values[indx] = value;
    }

    public T get(String key)
    {
        int testIndx = hashFun(key);

        if (slots[testIndx] == key) {
            return values[testIndx];
        }

        for (int i = testIndx + step; i < size + testIndx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == key) {
                return values[a];
            }
        }

        return null;
    }
}
