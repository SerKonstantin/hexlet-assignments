package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] tmpResult = new String[image.length][image[0].length * 2];
        for (int i = 0; i < image.length; i++) {
            tmpResult[i] = Arrays.stream(image[i])
                    .flatMap(value -> Stream.of(value, value))
                    .toArray(String[]::new);
        }

        return Arrays.stream(tmpResult)
                .flatMap(value -> Stream.of(value, value))
                .toArray(String[][]::new);
    }
}
// END
