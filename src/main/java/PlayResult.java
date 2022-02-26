public class PlayResult {
    private final int ball;
    private final int strike;

    public PlayResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String getResult() {
        if(strike == 0 && ball == 0){
            return "낫싱";
        }
        if (strike != 0 && ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0 && ball != 0) {
            return ball + "볼";
        }
        return strike + "스트라이크" + " " + ball + "볼";
    }

    public void printResult() {
        System.out.println(getResult());
    }
}
