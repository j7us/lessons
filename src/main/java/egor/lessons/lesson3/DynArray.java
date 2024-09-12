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
            int lenght = capacity < newCapacity
                    ? count - 1
                    : newCapacity - 1;

            System.arraycopy(array, 0, newCapacityArray, 0, lenght);
        }

        capacity = newCapacity;
        array = newCapacityArray;
    }

    public T getItem(int index)
    {
        if (index > capacity-1) {
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
        if (index > capacity-1) {
            throw new IndexOutOfBoundsException();
        }

        if (count == capacity) {
            makeArray(capacity * 2);
        }

        if (index > count - 1) {
            count++;
            array[index] = itm;
            return;
        }

        System.arraycopy(array, index, array, index + 1, count - index);

        count++;
        array[index] = itm;
    }

    public void remove(int index)
    {
        if (index > capacity-1) {
            throw new IndexOutOfBoundsException();
        }

        count--;

        if (index == count - 1) {
            array[index] = null;
            checkArraySize();
            return;
        }

        System.arraycopy(array, index + 1, array, index, capacity - index - 1);
        checkArraySize();
    }

    private void checkArraySize() {
        if (capacity != 16
                &&((capacity % 2 == 0 && count < capacity/2)
                || (capacity % 2 != 0 && count <= capacity/2))) {
            makeArray((int) (capacity/1.5));
        }
    }

}
