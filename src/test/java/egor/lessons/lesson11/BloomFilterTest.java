package egor.lessons.lesson11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BloomFilterTest {

    @Test
    void bloomTest() {
        BloomFilter filter = new BloomFilter(16);

        filter.add("0123456789");
        filter.add("1234567890");
        filter.add("8901234567");
        filter.add("9012345678");


        assertThat(filter.isValue("9012345678")).isTrue();
    }

    @Test
    void combineTest() {
        BloomFilter filter = new BloomFilter(16);

        filter.add("0123456789");
        filter.add("1234567890");
        filter.add("8901234567");
        filter.add("9012345678");

        BloomFilter filter2 = new BloomFilter(16);

        filter2.add("1425364758");

        filter.combine(List.of(filter2));

        assertThat(filter.isValue("1425364758")).isTrue();
    }
}
