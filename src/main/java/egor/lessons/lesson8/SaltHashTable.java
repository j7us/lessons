package egor.lessons.lesson8;

public class SaltHashTable {
    public int size;
    public int step;
    public String [] slots;
    private String salt = "12ecasdq3vs";

    public SaltHashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String val)
    {
        StringBuilder builder = new StringBuilder();

        int i = 0;

        for (char c : val.toCharArray()) {
            if (i % 2 == 0) {
                builder.append(c);
            }

            builder.append(1);
            builder.setCharAt(0, 'a');
        }

        builder.append(salt);

        int ind = builder.toString().hashCode() % size;

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
