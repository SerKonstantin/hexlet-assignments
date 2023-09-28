package exercise;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ReversedSequenceTest {
    @Test
    void test1() {
        ReversedSequence text = new ReversedSequence("abcdef");

        String actual1 = text.toString();
        assertThat(actual1).isEqualTo("fedcba");

        char actual2 = text.charAt(1);
        assertThat(actual2).isEqualTo('e');

        int actual3 = text.length();
        assertThat(actual3).isEqualTo(6);

        String actual4 = text.subSequence(1, 4).toString();
        assertThat(actual4).isEqualTo("edc");

        boolean actual5 = text.isEmpty();
        assertThat(actual5).isFalse();
    }
}
