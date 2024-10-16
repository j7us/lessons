package egor.lessons.lesson11;

import java.util.BitSet;

public class BloomFilterWithDeletePossibility {
    public int filter_len;
    private int[] counter;
    private BitSet bitSet;

    public BloomFilterWithDeletePossibility(int f_len)
    {
        filter_len = f_len;
        bitSet = new BitSet(filter_len);
        counter = new int[f_len];
    }

    // хэш-функции
    public int hash1(String str1)
    {
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = (hash * 17 + code) % filter_len;
        }
        return hash;
    }
    public int hash2(String str1)
    {
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = (hash * 223 + code) % filter_len;
        }
        return hash;
    }

    public void add(String str1)
    {
        int first = hash1(str1);
        int second = hash2(str1);
        bitSet.set(first);
        bitSet.set(second);
        counter[first] = counter[first] + 1;
        counter[second] = counter[second] + 1;
    }

    public boolean isValue(String str1)
    {
        int first = hash1(str1);
        int second = hash2(str1);
        return bitSet.get(first) && bitSet.get(second);
    }

    public boolean remove(String str1) {
        int first = hash1(str1);
        int second = hash2(str1);

        if (!(bitSet.get(first) && bitSet.get(second))) {
            return false;
        }

        counter[first] = counter[first] - 1;
        counter[second] = counter[second] - 1;
        checkIndex(first);
        checkIndex(second);

        return true;
    }

    private void checkIndex(int indx) {
        if (counter[indx] == 0) {
            bitSet.clear(indx);
        }
    }
}
