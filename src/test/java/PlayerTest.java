import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Scanner;

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
