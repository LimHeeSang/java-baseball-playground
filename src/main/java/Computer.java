import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Ball> ballBox = new ArrayList<>();

    public List<Ball> createRandomBall() {
        int idx = 1;
        while (ballBox.size() < Referee.GAME_TRY) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            Ball ball = new Ball(idx, randomNumber);

            if(ballBox.contains(ball)) continue;
            ballBox.add(ball);
            idx++;
        }

        return ballBox;
    }

    public List<Integer> getBallNumbers() {
        List<Integer> ballNumbers = new ArrayList<>();
        for (int i = 0; i < ballBox.size(); i++) {
            Ball ball = ballBox.get(i);
            ballNumbers.add(ball.getBallNumber());
        }

        return ballNumbers;
    }
}
