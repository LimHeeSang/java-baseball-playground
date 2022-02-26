import java.util.List;

public class Referee {
    public static final int GAME_TRY = 3;
    private int ball = 0;
    private int strike = 0;


    public PlayResult judge(List<Ball> computerBalls, List<Ball> playerBalls) {
        for (Ball playerBall : playerBalls) {
            judgeEachBall(computerBalls, playerBall);
        }
        return new PlayResult(ball, strike);
    }


    private void judgeEachBall(List<Ball> computerBalls, Ball playerBall) {
        for (Ball computerBall : computerBalls) {
            compareBall(computerBall, playerBall);
        }
    }

    private void compareBall(Ball computerBall, Ball playerBall) {
        if(computerBall.equals(playerBall) && computerBall.isEqualIndex(playerBall)) strike++;
        if(computerBall.equals(playerBall) && !computerBall.isEqualIndex(playerBall)) ball++;
    }
}
