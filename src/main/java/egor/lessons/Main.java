package egor.lessons;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        AAA<String[][]> aaa = new AAA<>(String.class, 1, 2, 3);

        String[][][] res = aaa.getRes();

        String[][] re = res[0];

        System.out.println(res[0][0][0]);
    }

    private static class AAA<T> {

        T[] res;

        public AAA(Class clz, int... length) {
            res = (T[]) Array.newInstance(clz, length);
        }

        public T[] getRes() {
            return res;
        }
    }
}