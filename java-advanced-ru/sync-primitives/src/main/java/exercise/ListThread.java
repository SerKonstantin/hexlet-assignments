package exercise;

// BEGIN
public class ListThread extends Thread {
    private final int amount = 1000;
    private SafetyList elements;

    ListThread(SafetyList elements) {
        this.elements = elements;
    }

    @Override
    public void run() {
        for (var i = 0; i < amount; i++) {
            try {
                sleep(1);
                elements.add(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// END
