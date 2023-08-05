package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        String[] words = sentence.split(" ");

        for (String word: words) {
            if (word.equals("")) {
                System.out.println("Error: Multiple spaces in a row");
                return new HashMap();
            } else if (wordsCountMap.containsKey(word)) {
                int value = wordsCountMap.get(word);
                wordsCountMap.put(word, value + 1);
            } else {
                int value = 1;
                wordsCountMap.put(word, value);
            }
        }

        return wordsCountMap;
    }


    public static String toString(Map<String, Integer> wordsCountMap) {
        if (wordsCountMap.isEmpty()) {
            return "{}";
        }

        String result = "{\n";
        for (Map.Entry<String, Integer> wordCountPair: wordsCountMap.entrySet()) {
            result += "  " + wordCountPair.getKey() + ": " + wordCountPair.getValue() + "\n";
        }
        result += "}";

        return result;
    }
}
//END
