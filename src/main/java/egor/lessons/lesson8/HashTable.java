package egor.lessons.lesson8;

public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int ind = value.hashCode() % size;

        return ind < 0
                ? ind * -1
                : ind;
    }

    public int seekSlot(String value)
    {
        int indx = hashFun(value);

        if (slots[indx] == null) {
            return indx;
        }

        for (int i = indx + step; i < size + indx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == null) {
                return a;
            }
        }

        return -1;
    }

    public int put(String value)
    {
       int resIndx = seekSlot(value);

        if (resIndx >= 0) {
            slots[resIndx] = value;
        }

        return resIndx;
    }

    public int find(String value)
    {
        int testIndx = hashFun(value);

        if (slots[testIndx] == value) {
            return testIndx;
        }

        for (int i = testIndx + step; i < size + testIndx - 1; i += step) {
            int a = i < size - 1
                    ? i
                    : i - (size - 1);

            if (slots[a] == value) {
                return a;
            }
        }

        return -1;
    }
}
