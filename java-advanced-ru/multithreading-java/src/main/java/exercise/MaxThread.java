package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int tmp = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > tmp) {
                tmp = num;
            }
        }
        this.max = tmp;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getMax() {
        return max;
    }
}

// END
