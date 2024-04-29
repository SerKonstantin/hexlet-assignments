package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        var threadMax = new MaxThread(numbers);
        var threadMin = new MinThread(numbers);

        threadMax.start();
        threadMin.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        var results = new HashMap<String, Integer>();
        results.put("min", threadMin.getMin());
        results.put("max", threadMax.getMax());

        return results;
    }
    // END
}
