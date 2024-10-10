package egor.lessons.lesson10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerSetTest {

    @Test
    void putTest() {
        PowerSet powerSet = new PowerSet();

        powerSet.put("AAAAA");

        assertThat(powerSet.get("AAAAA")).isTrue();
    }

    @Test
    void putRepeatTest() {
        PowerSet powerSet = new PowerSet();

        powerSet.put("AAAAA");
        powerSet.put("AAAAA");

        powerSet.remove("AAAAA");

        assertThat(powerSet.get("AAAAA")).isFalse();
    }

    @Test
    void removeTest() {
        PowerSet powerSet = new PowerSet();

        powerSet.put("AAAAA");
        powerSet.remove("AAAAA");

        assertThat(powerSet.get("AAAAA")).isFalse();
    }

    @Test
    void intersectionEmptyTest() {
        PowerSet powerSet = new PowerSet();

        PowerSet inter = new PowerSet();
        inter.put("A");

        PowerSet res = powerSet.intersection(inter);

        assertThat(res.size()).isEqualTo(0);
    }

    @Test
    void intersectionTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("A");

        PowerSet inter = new PowerSet();
        inter.put("A");

        PowerSet res = powerSet.intersection(inter);

        assertThat(res.size()).isEqualTo(1);
    }

    @Test
    void intersectionDifferentTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");

        PowerSet res = powerSet.intersection(inter);

        assertThat(res.size()).isEqualTo(0);
    }

    @Test
    void unionTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");

        PowerSet res = powerSet.union(inter);

        assertThat(res.size()).isEqualTo(2);
    }

    @Test
    void differenceTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("C");
        powerSet.put("A");
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");
        inter.put("B");

        PowerSet res = powerSet.difference(inter);

        assertThat(res.size()).isEqualTo(1);
    }

    @Test
    void subSetTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("C");
        powerSet.put("A");
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");
        inter.put("B");

        boolean res = powerSet.isSubset(inter);

        assertThat(res).isTrue();
    }

    @Test
    void subSetFalseTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("C");
        powerSet.put("A");
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");
        inter.put("B");
        inter.put("D");

        boolean res = powerSet.isSubset(inter);

        assertThat(res).isFalse();
    }

    @Test
    void equalsTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("C");
        powerSet.put("A");
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");
        inter.put("B");
        inter.put("C");

        boolean res = powerSet.equals(inter);

        assertThat(res).isTrue();
    }

    @Test
    void equalsFalseTest() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("C");
        powerSet.put("A");
        powerSet.put("B");

        PowerSet inter = new PowerSet();
        inter.put("A");
        inter.put("B");

        boolean res = powerSet.equals(inter);

        assertThat(res).isFalse();
    }

    @Test
    void sizeTest() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 15000; i++) {
            powerSet.put("v" + i);
        }

        for (int i = 0; i < 100; i++) {
            powerSet.remove("AA");
        }

        powerSet.remove("v0");

        assertThat(powerSet.size()).isEqualTo(14999);
    }
}
