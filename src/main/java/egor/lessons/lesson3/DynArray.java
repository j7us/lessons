package egor.lessons.lesson3;

import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
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
        if (count == capacity) {
            makeArray(capacity * 2);
        }

        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index)
    {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (count == capacity) {
            makeArray(capacity * 2);
        }

        if (index < count) {
            System.arraycopy(array, index, array, index + 1, count - index);
        }

        count++;
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
            checkArraySize();
            return;
        }

        System.arraycopy(array, index + 1, array, index, count - index - 1);
        array[count-1] = null;
        count--;
        checkArraySize();
    }

    private void checkArraySize() {
        if (capacity > 16
                && ((capacity % 2 == 0 && count < capacity/2)
                || (capacity % 2 != 0 && count <= capacity/2))) {
            makeArray((int) (capacity/1.5));
        }
    }
}
