package egor.lessons.lesson8;

import java.util.Random;
import java.util.function.Function;

public class MultipleHashFunctionTable {
    public int size;
    public int step;
    public String [] slots;
    private Function<String, Integer> firstHash;
    private Function<String, Integer> secondHash;

    public MultipleHashFunctionTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
        firstHash = getHashFunction();
        secondHash = getHashFunction();
        checkHashFunctions();
    }

    private Function<String, Integer> getHashFunction() {
        Random random = new Random();
        int p = 97;
        int a = random.nextInt(p-2) + 1;
        int b = random.nextInt(p-2) + 1;

        return (String s) -> ((s.hashCode() * a + b) % p) % size;
    }

    private void checkHashFunctions() {
        String test = "AAbcasdlk12345";

        if (firstHash.apply(test).equals(secondHash.apply(test))) {
            secondHash = getHashFunction();
            checkHashFunctions();
        }
    }

    public int hashFun(String value, Function<String, Integer> hashFun)
    {
        int ind = hashFun.apply(value);

        return ind < 0
                ? ind * -1
                : ind;
    }

    public int seekSlot(String value)
    {
        int indxFirst = hashFun(value, firstHash);
        int indxSecond = hashFun(value, secondHash);

        if (slots[indxFirst] == null || slots[indxSecond] == null) {
            return slots[indxFirst] == null ? indxFirst : indxSecond;
        }

        for (int i = indxFirst + step, x = indxSecond + step;
                i < size + indxFirst - 1 || x < size + indxSecond - 1;
                i += step, x += step) {

            int a = i < size - 1
                    ? i
                    : i - (size - 1);
            int b = x < size - 1
                    ? x
                    : x - (size - 1);

            if (a < size - 1 && slots[a] == null) {
                return a;
            }

            if (b < size - 1 && slots[b] == null) {
                return b;
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
        int testIndxFirst = hashFun(value, firstHash);
        int testIndxSecond = hashFun(value, secondHash);

        if (slots[testIndxFirst].equals(value) || slots[testIndxSecond].equals(value)) {
            return slots[testIndxFirst].equals(value) ? testIndxFirst : testIndxSecond;
        }

        for (int i = testIndxFirst + step, x = testIndxSecond + step;
                i < size + testIndxFirst - 1 || x < size + testIndxSecond;
                i += step, x += step) {

            int a = i < size - 1
                    ? i
                    : i - (size - 1);
            int b = x < size - 1
                    ? x
                    : x - (size - 1);

            if (a < size - 1 && slots[a].equals(value)) {
                return a;
            }

            if (b < size - 1 && slots[b].equals(value)) {
                return b;
            }
        }

        return -1;
    }
}
