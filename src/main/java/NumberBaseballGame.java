import java.util.Arrays;
import java.util.Scanner;

public class NumberBaseballGame {
    private final int TRY = 3;
    private int[] computer = new int[TRY];
    private int[] user = new int[TRY];
    private int strike;
    private int ball;

    {
        setComputer();
        System.out.println(Arrays.toString(computer));
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void setComputer(){
        for (int i = 0; i < computer.length; i++) {
            computer[i] = (int) (Math.random() * 9) + 1;
        }
    }

    public void setUser(String input) {
        for (int i = 0; i < user.length; i++) {
            user[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
    }

    private void playGame() {
        ball = 0;
        strike = 0;
        for (int i = 0; i < TRY; i++) {
            for (int j = 0; j < TRY; j++) {
                compareUserToComputer(i, j);
            }
        }
    }

    private void compareUserToComputer(int i, int j) {
        if(user[i] == computer[j]){
            if(i == j) strike++;
            else ball++;
        }
    }

    private String inputGameData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    public void operation() {
        int check = checkRestart();
        if(check == 1) operation();
        if(check == 2) return;

        String inputData = inputGameData();
        setUser(inputData);

        playGame();
        printGameResult();

        operation();


    }

    private int checkRestart() {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }
        return 0;
    }

    private void printGameResult() {
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if(ball != 0 && strike == 0){
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
    }
}
