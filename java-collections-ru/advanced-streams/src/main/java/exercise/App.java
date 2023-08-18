package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String data) {
        String[] dataLines = data.split("\n");

        List<String> resultsAsList = Arrays.stream(dataLines)
                .filter(line -> line.startsWith("environment="))
                .flatMap(line -> Arrays.stream(line.split(",|\"")))
                .filter(partOfLine -> partOfLine.startsWith("X_FORWARDED_"))
                .map(partOfLine -> partOfLine.split("X_FORWARDED_")[1])
                .collect(Collectors.toList());

        return String.join(",", resultsAsList);
    }
}
//END
