import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballGameTest {
    NumberBaseballGame baseballGame = new NumberBaseballGame();

    @Test
    void setComputer() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method method = NumberBaseballGame.class.getDeclaredMethod("setComputer");
        method.setAccessible(true);
        method.invoke(baseballGame);

        Field field = NumberBaseballGame.class.getDeclaredField("computer");
        field.setAccessible(true);
        int[] actual = (int[]) field.get(baseballGame);

        //배열의 각 요소가 1~9사이의 숫자인지 검증
        for (int i = 0; i < actual.length; i++) {
            Assertions.assertTrue(actual[i] >=1 && actual[i] <= 9);
        }
    }

    @Test
    void setUser() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        int[] expect = {1, 2, 3};

        Method method = NumberBaseballGame.class.getDeclaredMethod("setUser", String.class);
        method.setAccessible(true);
        method.invoke(baseballGame, "123");

        Field field = NumberBaseballGame.class.getDeclaredField("user");
        field.setAccessible(true);
        int[] actual = (int[]) field.get(baseballGame);

        for (int i = 0; i < actual.length; i++) {
            org.assertj.core.api.Assertions.assertThat(actual[i]).isEqualTo(expect[i]);
        }
    }



}