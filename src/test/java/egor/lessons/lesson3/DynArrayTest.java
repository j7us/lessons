package egor.lessons.lesson3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynArrayTest {

    @Test
    void capacityTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.makeArray(32);

        assertThat(array.capacity).isEqualTo(32);
    }

    @Test
    void capacityWithCopyTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.append(3);

        array.makeArray(32);

        assertThat(array.getItem(1)).isEqualTo(2);
    }

    @Test
    void appendWithNewCapacityTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        for (int i = 0; i < 20; i++) {
            array.append(1);
        }

        assertThat(array.capacity).isEqualTo(32);
    }

    @Test
    void appendWithoutNewCapacityTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);

        assertThat(array.capacity).isEqualTo(16);
    }

    @Test
    void insertTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.append(3);

        array.insert(17, 1);

        assertThat(array.getItem(1)).isEqualTo(17);
    }

    @Test
    void insertWithExceptionTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.append(3);

        boolean isException = false;

        try {
            array.insert(17, 70);
        } catch (IndexOutOfBoundsException e) {
            isException = true;
        }


        assertThat(isException).isTrue();
    }

    @Test
    void removeTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.append(3);

        array.remove(2);

        assertThat(array.capacity).isEqualTo(16);
    }

    @Test
    void removeWithExceptionTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        boolean isException = false;

        try {
            array.remove( 70);
        } catch (IndexOutOfBoundsException e) {
            isException = true;
        }

        assertThat(isException).isTrue();
    }

    @Test
    void removeWithCapacityTest() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        for (int i = 0; i < 20; i++) {
            array.append(1);
        }

        for (int i = 0; i < 10; i++) {
            array.remove(0);
        }

        assertThat(array.capacity).isEqualTo(16);
    }
}
