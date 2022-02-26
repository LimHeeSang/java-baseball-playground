import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String END_POINT = "3스트라이크";

    private final Computer computer = new Computer();
    private final Player player = new Player();
    private final Referee referee = new Referee();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Application application = new Application();
        application.startGame();
    }

    private String playOneGame() {
        List<Ball> computerBalls = computer.createRandomBall();
        List<Ball> playerBalls = player.play();

        PlayResult playResult = referee.judge(computerBalls, playerBalls);
        playResult.printResult();

        return playResult.getResult();
    }

    private void startGame() {
        while (true) {
            String result = playOneGame();

            if(result.equals(END_POINT)){
                if(isRestart()){
                    computer.initBallBox();
                    continue;
                }
                break;
            }
        }
    }

    private boolean isRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int select = scanner.nextInt();
        if(select == 1) {
            return true;
        }
        return false;
    }

}
