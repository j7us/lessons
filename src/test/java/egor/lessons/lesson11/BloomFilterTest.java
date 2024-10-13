package egor.lessons.lesson11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BloomFilterTest {

    @Test
    void bloomTest() {
        BloomFilter filter = new BloomFilter(16);

        filter.add("0123456789");

        assertThat(filter.isValue("01231456789")).isFalse();
    }
}
