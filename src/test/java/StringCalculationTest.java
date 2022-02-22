import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class StringCalculationTest {
    StringCalculation calculation = new StringCalculation();

    @Test
    void add() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StringCalculation.class.getDeclaredMethod("add", int.class, int.class);
        method.setAccessible(true);
        int actual = (int) method.invoke(calculation, 2, 3);

        Assertions.assertThat(actual).isEqualTo(5);
    }

    @Test
    void sub() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StringCalculation.class.getDeclaredMethod("sub", int.class, int.class);
        method.setAccessible(true);
        int actual = (int) method.invoke(calculation, 5, 3);

        Assertions.assertThat(actual).isEqualTo(2);
    }

    @Test
    void mul() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StringCalculation.class.getDeclaredMethod("mul", int.class, int.class);
        method.setAccessible(true);
        int actual = (int) method.invoke(calculation, 5, 3);

        Assertions.assertThat(actual).isEqualTo(15);
    }

    @Test
    void div() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = StringCalculation.class.getDeclaredMethod("div", int.class, int.class);
        method.setAccessible(true);
        int actual = (int) method.invoke(calculation, 6, 3);

        Assertions.assertThat(actual).isEqualTo(2);
    }

    @Test
    void operation() {
        calculation.setTarget("2 + 3 * 4 / 2");

        int result = calculation.operation();

        Assertions.assertThat(result).isEqualTo(10);
    }
}