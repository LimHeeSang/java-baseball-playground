public class Ball {
    private final int index;
    private final int number;


    public Ball(int index, int number) {
        validateIndexAndNumber(index, number);
        this.index = index;
        this.number = number;
    }

    private void validateIndexAndNumber(int index, int number) {
        if (index < 0 || index > 3) {
            throw new IllegalArgumentException();
        }
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException();
        }
    }

    public int getBallNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ball){
            return number == ((Ball) obj).getBallNumber();
        }
        return false;
    }
}
