package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        //given
        String str = "1,2";
        String str2 = "1";

        //when
        String[] splited = str.split(",");
        String[] splited2 = str2.split(",");

        //then
        Assertions.assertThat(splited[0]).isEqualTo("1");
        Assertions.assertThat(splited[1]).isEqualTo("2");

        Assertions.assertThat(splited2[0]).isEqualTo("1");
    }

    @Test
    void substring() {
        //given
        String str = "(1,2)";

        //when
        String result = str.substring(1, 4);

        //then
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        //given
        String str = "abc";

        //when
        char c = str.charAt(0);

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(5));

        //then
        Assertions.assertThat(c).isEqualTo('a');
    }
}
