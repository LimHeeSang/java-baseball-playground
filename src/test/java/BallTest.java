import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @Test
    @DisplayName("야구공의 범위 검증")
    void createBall() {
        Ball ball = new Ball(1, 2);
        int ballNumber = ball.getBallNumber();

        Assertions.assertTrue(ballNumber >= 1 && ballNumber <= 9);
    }

    @Test
    @DisplayName("위치가 달라도 같은 볼인지 검증")
    void equalsSameBall() {
        Ball ball = new Ball(1, 9);
        Ball ball2 = new Ball(3, 9);

        Assertions.assertTrue(ball.equals(ball2));
    }
}
