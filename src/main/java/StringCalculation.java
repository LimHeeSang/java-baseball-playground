public class StringCalculation {
    private String[] list;

    public void setTarget(String target) {
        list = target.split(" ");
    }

    private int add(int x, int y) {
        return x + y;
    }

    private int sub(int x, int y) {
        return x - y;
    }

    private int mul(int x, int y) {
        return x * y;
    }

    private int div(int x, int y) {
        return x / y;
    }

    public int operation() {
        int temp = Integer.parseInt(list[0]);

        for (int i = 1; i < list.length; i+=2) {
            if(list[i].equals("+")){
                temp = add(temp, Integer.parseInt(list[i + 1]));
            } else if (list[i].equals("-")) {
                temp = sub(temp, Integer.parseInt(list[i + 1]));
            } else if (list[i].equals("*")) {
                temp = mul(temp, Integer.parseInt(list[i + 1]));
            } else if (list[i].equals("/")) {
                temp = div(temp, Integer.parseInt(list[i + 1]));
            }
        }

        return temp;
    }

}
