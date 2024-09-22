package egor.lessons.lesson3;

import java.lang.reflect.Array;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class BankMethodDynArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    private int changesCount;
    Class clazz;

    public BankMethodDynArray(Class clz)
    {
        clazz = clz;
        count = 0;
        makeArray(16);
    }

    private boolean isEnoughChangesToResize(int newCapacity) {
        return changesCount >= getResizeCost(newCapacity);
    }

    private int getResizeCost(int newCapacity) {
        return (int) pow(2, log(newCapacity)/log(2));
    }

    public void makeArray(int new_capacity)
    {
        int newCapacity = Math.max(new_capacity, 16);

        T[] newCapacityArray = (T[]) Array.newInstance(this.clazz, newCapacity);

        if (count != 0) {
            int length = Math.min(count, newCapacity);

            System.arraycopy(array, 0, newCapacityArray, 0, length);
        }

        capacity = newCapacity;
        array = newCapacityArray;
    }

    public T getItem(int index)
    {
        if (index > count-1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    public void append(T itm)
    {
        if (isEnoughChangesToResize(capacity * 2)) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
        changesCount += 3;
    }

    public void insert(T itm, int index)
    {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (isEnoughChangesToResize(capacity * 2)) {
            makeArray(capacity * 2);
        }

        if (index < count) {
            System.arraycopy(array, index, array, index + 1, count - index);
        }

        count++;
        changesCount += 3;
        array[index] = itm;
    }

    public void remove(int index)
    {
        if (index > count-1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == count - 1) {
            array[index] = null;
            count--;
            changesCount += 3;
            checkArraySize();
            return;
        }

        System.arraycopy(array, index + 1, array, index, count - index - 1);
        array[count-1] = null;
        count--;
        changesCount += 3;
        checkArraySize();
    }

    private void checkArraySize() {
        if (capacity > 16
                && isEnoughChangesToResize((int) (capacity/1.5))) {
            makeArray((int) (capacity/1.5));
        }
    }
}
