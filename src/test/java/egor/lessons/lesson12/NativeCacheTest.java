package egor.lessons.lesson12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NativeCacheTest {

    @Test
    void cacheTest() {
        NativeCache<Integer> cache = new NativeCache<>(16, Integer.class);

        for (int i = 0; i < 17; i++) {
            String key = "a" + i;
            cache.put(key, i);

            if (!key.equals("a1") && !key.equals("a4")) {
                cache.get(key);
            }
        }

        assertThat(cache.get("a16")).isEqualTo(16);
    }
}
