package egor.lessons.lesson11;

import java.util.BitSet;

public class BloomFilter
{
    public int filter_len;
    private BitSet bitSet;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitSet = new BitSet(filter_len);
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
    }

    public boolean isValue(String str1)
    {
        int first = hash1(str1);
        int second = hash2(str1);
        return bitSet.get(first) && bitSet.get(second);
    }
}
