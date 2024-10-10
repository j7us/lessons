package egor.lessons.lesson8;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class SaltHashTable {
    public int size;
    public int step;
    public Node [] slots;

    public SaltHashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new Node[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(Node val)
    {

        int ind = val.getHashWithSalt() % size;

        return ind < 0
                ? ind * -1
                : ind;
    }

    public int seekSlot(Node value)
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
        Node node = new Node(value, generateSalt());
        int resIndx = seekSlot(node);

        if (resIndx >= 0) {
            slots[resIndx] = node;
        }

        return resIndx;
    }

    public String generateSalt() {
        byte[] array = new byte[31];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    static class Node {
        private String val;
        private String salt;

        public Node(String val, String salt) {
            this.val = val;
            this.salt = salt;
        }

        public String getVal() {
            return val;
        }

        public String getSalt() {
            return salt;
        }

        public int getHashWithSalt() {
            return val.concat(salt).hashCode();
        }
    }
}
