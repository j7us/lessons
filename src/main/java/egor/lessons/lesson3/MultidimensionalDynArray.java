package egor.lessons.lesson3;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.pow;

public class MultidimensionalDynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    private Map<Integer, Integer> dimensionalSize = new HashMap<>();
    private int[] length;
    private int dimensional;
    Class clazz;

    public MultidimensionalDynArray(Class clz, int dimensional, int... length) {
        clazz = clz;
        this.dimensional = dimensional;
        fillCapacityAndDimensionalSize(length);
        makeArray(capacity, length);
    }

    private void fillCapacityAndDimensionalSize(int[] length) {
        dimensionalSize.put(dimensional - 1, 0);

        int lengthIndex = length.length - 1;
        int dimensionalLevel = dimensional - 2;
        int resultCapacity = length[lengthIndex];
        dimensionalSize.put(dimensionalLevel, resultCapacity);

        for (int i = 1; i < dimensional-1; i++) {
            resultCapacity = resultCapacity * length[lengthIndex-i];
            dimensionalSize.put(dimensionalLevel-i, resultCapacity);
        }

        capacity = resultCapacity * length[0];
    }

    public void makeArray(int new_capacity, int[] length)
    {
        int newCapacity = Math.max(new_capacity, 16);

        T[] newCapacityArray = (T[]) Array.newInstance(this.clazz, newCapacity);

        array = newCapacityArray;
        capacity = newCapacity;
        this.length = length;
    }

    public T getItem(int... indexes) {
        int resultIndex = calculateIndex(indexes);

        return array[resultIndex];
    }

    private int calculateIndex(int[] indexes) {
        int resultIndex = 0;
        for (int i = 0; i < dimensional-1; i++) {
            if (indexes[i] >= length[i]) {
                throw new IndexOutOfBoundsException();
            }
            resultIndex = resultIndex + indexes[i]*dimensionalSize.get(i);
        }

        if (indexes[dimensional-1] >= length[dimensional-1]) {
            throw new IndexOutOfBoundsException();
        }

        return resultIndex + indexes[dimensional-1];
    }

    public void append(T item, int... indexes) {
        if (count == capacity) {
            makeArray(capacity * (int) (pow(2, dimensional)), buildNewLength());
        }

        int index = calculateIndex(indexes);

        T before = array[index];
        array[index] = item;
        if (before == null) {
            count++;
        }
    }

    private int[] buildNewLength() {
        int[] newLength = new int[dimensional];

        for (int i = 0; i < dimensional; i++) {
            newLength[i] = length[i] * 2;
        }

        return newLength;
    }
}
