import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final List<Ball> ballBox = new ArrayList<>();

    public List<Ball> play() {
        inputData();
        return ballBox;
    }

    private void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요 : ");
        String data = scanner.next();
        String[] numbers = data.split("");

        for (int i = 0; i < Referee.GAME_TRY; i++) {
            ballBox.add(new Ball(i + 1, Integer.parseInt(numbers[i])));
        }
    }


}
