package egor.lessons.lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class MultidimensionalDynArray<T> {

    public Object [] array;
    private int dimensional;
    private Class clazz;
    private int[] levelCapacity;

    public MultidimensionalDynArray(Class clazz, int dimensional, int... lengths) {
        this.clazz = clazz;
        this.dimensional = dimensional;
        array = (Object[]) Array.newInstance(clazz, lengths);
        fillLevelCapacity(dimensional, lengths);
    }

    private void fillLevelCapacity(int dimensional, int... lengths) {
        levelCapacity = new int[dimensional];

        for (int i = 0; i < dimensional; i--) {
            levelCapacity[i] = lengths[i];
        }
    }

    public T getItem(int... coordinates) {
        Object[] currentArray = array;

        for (int i = 0; i < dimensional - 1; i++) {
            if (coordinates[i] > levelCapacity[i]) {
                throw new IndexOutOfBoundsException();
            }
            currentArray = (Object[]) currentArray[coordinates[i]];
        }

        return (T) currentArray[coordinates[dimensional - 1]];
    }

    public void append(T item, int... coordinates) {
        Object[] currentArray = array;

        for (int x = 0; x < coordinates.length - 1; x++) {
            currentArray = (Object[]) currentArray[coordinates[x]];
        }

        currentArray[coordinates[coordinates.length - 1]] = item;
    }
}
