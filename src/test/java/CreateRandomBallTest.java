import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CreateRandomBallTest {
    private final Computer computer = new Computer();

    @Test
    @DisplayName("1~9의 랜덤야구공 만들기")
    void createRandomNumber() {
        List<Ball> randomBalls = computer.createRandomBall();

        for (int i = 0; i < Referee.GAME_TRY; i++) {
            Ball ball = randomBalls.get(i);
            int ballNumber = ball.getBallNumber();
            Assertions.assertTrue(ballNumber >= 1 && ballNumber <= 9);
        }
    }

    @Test
    @DisplayName("만든 숫자 중 겹치는 숫자가 있는지 검증")
    void validateDuplication() {
        computer.createRandomBall();

        List<Integer> ballNumbers = computer.getBallNumbers();

        Assertions.assertTrue(ballNumbers.get(0) != ballNumbers.get(1)
                && ballNumbers.get(1) != ballNumbers.get(2) && ballNumbers.get(0) != ballNumbers.get(2));
    }

}
