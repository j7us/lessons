package egor.lessons.lesson8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTableDdosTest {

    @Test
    void ddosTest() {
        HashTable table = new HashTable(27, 3);

        int hash1 = table.hashFun("AaAa");
        int hash2 = table.hashFun("BBBB");
        int hash3 = table.hashFun("AaBB");
        int hash4 = table.hashFun("BBAa");

        assertThat(hash1)
                .isEqualTo(hash2)
                .isEqualTo(hash3)
                .isEqualTo(hash4);
    }

    @Test
    void ddosWithSaltTest() {
        SaltHashTable table = new SaltHashTable(27, 3);

        int hash1 = table.hashFun("AaAa");
        int hash2 = table.hashFun("BBBB");
        int hash3 = table.hashFun("AaBB");
        int hash4 = table.hashFun("BBAa");

        assertThat(hash1)
                .isNotEqualTo(hash2)
                .isNotEqualTo(hash3)
                .isNotEqualTo(hash4);
    }
}
