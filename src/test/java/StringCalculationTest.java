import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class StringCalculationTest {
    StringCalculation calculation = new StringCalculation();

    @Test
    void setTarget() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        String[] expect = {"2", "+", "3", "*", "4", "/", "2"};

        Method method = StringCalculation.class.getDeclaredMethod("setTarget", String.class);
        method.setAccessible(true);
        method.invoke(calculation, "2 + 3 * 4 / 2");

        Field field = StringCalculation.class.getDeclaredField("list");
        field.setAccessible(true);
        String[] actual = (String[]) field.get(calculation);

        for (int i = 0; i < actual.length; i++) {
            Assertions.assertThat(actual[i]).isEqualTo(expect[i]);
        }
    }


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
        int result = calculation.operation("2 + 3 * 4 / 2");

        Assertions.assertThat(result).isEqualTo(10);
    }
}