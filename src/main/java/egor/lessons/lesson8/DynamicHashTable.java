package egor.lessons.lesson8;

import egor.lessons.lesson3.DynArray;

import java.util.ArrayList;

public class DynamicHashTable {
    public int step;
    public int count;
    public DynArray<String> slots;

    public DynamicHashTable()
    {
        step = 3;
        slots = new DynArray<>(String.class);
    }

    public int hashFun(String value)
    {
        int ind = value.hashCode() % slots.getCapacity();

        return ind < 0
                ? ind * -1
                : ind;
    }

    public int seekSlot(String value)
    {
        int indx = hashFun(value);

        if (slots.getItem(indx) == null) {
            return indx;
        }

        for (int i = indx + step; i < slots.getCapacity() + indx - 1; i += step) {
            int a = i < slots.getCapacity() - 1
                    ? i
                    : i - (slots.getCapacity() - 1);

            if (slots.getItem(a) == null) {
                return a;
            }
        }

        resize();
        return seekSlot(value);
    }

    public int put(String value)
    {
        if (count/(slots.getCapacity()/100.00) > 80.0) {
            resize();
        }
        int resIndx = seekSlot(value);

        if (resIndx >= 0) {
            count++;
            slots.insertWithoutCopy(value, resIndx);
        }

        return resIndx;
    }

    private void resize() {
        ArrayList<String> strings = new ArrayList<>(slots.getCapacity());

        for (int i = 0; i < slots.getCapacity(); i++) {
            if (slots.getItem(i) != null) {
                strings.add(slots.getItem(i));
                slots.insertWithoutCopy(null, i);
            }
        }

        slots.makeArray(slots.getCapacity() * 2);
        count = 0;

        strings.forEach(this::put);
    }

    public int find(String value)
    {
        int testIndx = hashFun(value);

        if (value.equals(slots.getItem(testIndx))) {
            return testIndx;
        }

        for (int i = testIndx + step; i < slots.getCapacity() + testIndx - 1; i += step) {
            int a = i < slots.getCapacity() - 1
                    ? i
                    : i - (slots.getCapacity() - 1);

            if (value.equals(slots.getItem(a))) {
                return a;
            }
        }

        return -1;
    }
}
