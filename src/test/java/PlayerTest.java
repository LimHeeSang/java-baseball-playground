import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class PlayerTest {
    private final Player player = new Player();

    @Test
    void inputUserBalls() {
        List<Ball> playerBalls = player.play();

        for (int i = 0; i < Referee.GAME_TRY; i++) {
            Ball ball = playerBalls.get(i);
            int ballNumber = ball.getBallNumber();
            Assertions.assertTrue(ballNumber >= 1 && ballNumber <= 9);
        }
    }


}
