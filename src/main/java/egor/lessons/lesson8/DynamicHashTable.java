package egor.lessons.lesson8;

public class DynamicHashTable {
    public int step;
    private int count;
    public String [] slots;

    public DynamicHashTable()
    {
        step = 3;
        slots = new String[16];
        for(int i=0; i<slots.length; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int ind = value.hashCode() % slots.length;

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

        for (int i = indx + step; i < slots.length + indx - 1; i += step) {
            int a = i < slots.length - 1
                    ? i
                    : i - (slots.length - 1);

            if (slots[a] == null) {
                return a;
            }
        }

        return -1;
    }

    public int put(String value)
    {
        if (count/(slots.length/100.00) > 75.0) {
            resize();
        }

        int resIndx = seekSlot(value);

        if (resIndx >= 0) {
            slots[resIndx] = value;
            count++;
        }

        return resIndx;
    }

    private void resize() {
        String[] currentArray = slots;
        int size = slots.length * 2;
        slots = new String[size];
        count = 0;

        for (String str : currentArray) {
            if (str != null) {
                put(str);
            }
        }
    }

    public int find(String value)
    {
        int testIndx = hashFun(value);

        if (slots[testIndx] != null && slots[testIndx].equals(value)) {
            return testIndx;
        }

        for (int i = testIndx + step; i < slots.length + testIndx - 1; i += step) {
            int a = i < slots.length - 1
                    ? i
                    : i - (slots.length - 1);

            if (slots[a] != null && slots[a].equals(value)) {
                return a;
            }
        }

        return -1;
    }
}
