import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RefereeTest {
    private final Referee referee = new Referee();

    List<Ball> testComputerBalls = new ArrayList<>();
    List<Ball> threeStrikeTestPlayerBalls = new ArrayList<>();
    List<Ball> oneStrikeTwoBallTestPlayerBalls = new ArrayList<>();
    List<Ball> nothingTestPlayBalls = new ArrayList<>();
    List<Ball> oneStrikeOneBallTestPlayerBalls = new ArrayList<>();
    List<Ball> twoBallTestPlayerBalls = new ArrayList<>();

    @BeforeEach
    void initForTest() {

        for (int i = 0; i < Referee.GAME_TRY; i++) {
            testComputerBalls.add(new Ball(i + 1, i + 1));    //computerBall -> 1, 2, 3

            threeStrikeTestPlayerBalls.add(new Ball(i + 1, i + 1));    //playBall -> 1, 2, 3 => 3스트라이크
            oneStrikeTwoBallTestPlayerBalls.add(new Ball(i + 1, 3 - i));    //playBall -> 3, 2, 1 => 1스트라이크 2볼
            nothingTestPlayBalls.add(new Ball(i + 1, i + 4));    //playBall -> 4, 5, 6 => 낫싱
        }

        oneStrikeOneBallTestPlayerBalls.add(new Ball(1, 1));    //playBall -> 1, 3, 5 => 1스트라이크 1볼
        oneStrikeOneBallTestPlayerBalls.add(new Ball(1, 3));
        oneStrikeOneBallTestPlayerBalls.add(new Ball(1, 5));

        twoBallTestPlayerBalls.add(new Ball(1, 3));    //playBall -> 3, 7, 1 => 2볼
        twoBallTestPlayerBalls.add(new Ball(2, 7));
        twoBallTestPlayerBalls.add(new Ball(3, 1));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void strike_3() {
        PlayResult playResult = referee.judge(testComputerBalls, threeStrikeTestPlayerBalls);
        Assertions.assertThat(playResult.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("1스트라이크 2볼 테스트")
    void strike_1_ball_2() {
        PlayResult playResult = referee.judge(testComputerBalls, oneStrikeTwoBallTestPlayerBalls);
        Assertions.assertThat(playResult.getResult()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothing() {
        PlayResult playResult = referee.judge(testComputerBalls, nothingTestPlayBalls);
        Assertions.assertThat(playResult.getResult()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void strike_1_ball_1() {
        PlayResult playResult = referee.judge(testComputerBalls, oneStrikeOneBallTestPlayerBalls);
        Assertions.assertThat(playResult.getResult()).isEqualTo("1스트라이크 1볼");
    }

    @Test
    @DisplayName("2볼")
    void ball_2() {
        PlayResult playResult = referee.judge(testComputerBalls, twoBallTestPlayerBalls);
        Assertions.assertThat(playResult.getResult()).isEqualTo("2볼");
    }

}
