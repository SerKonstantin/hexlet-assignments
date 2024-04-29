package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int tmp = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < tmp) {
                tmp = num;
            }
        }
        this.min = tmp;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMin() {
        return min;
    }
}
// END
