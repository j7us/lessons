package egor.lessons.lesson6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeFinderTest {

    @Test
    void palindromeOddTest() {
        String test = "abcdcba";

        boolean res = PalindromeFinder.isPalindrome(test);

        assertThat(res).isTrue();
    }

    @Test
    void palindromeTest() {
        String test = "abccba";

        boolean res = PalindromeFinder.isPalindrome(test);

        assertThat(res).isTrue();
    }

    @Test
    void palindromeFalseTest() {
        String test = "abcafcba";

        boolean res = PalindromeFinder.isPalindrome(test);

        assertThat(res).isFalse();
    }
}
