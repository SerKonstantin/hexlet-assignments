package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String setOfLetters, String word) {
        String[] letters = setOfLetters.toLowerCase().split("");
        List<String> setOfLettersAsList = new ArrayList<>(Arrays.asList(letters));

        String[] lettersInWord = word.toLowerCase().split("");

        for (String letter: lettersInWord) {
            if (setOfLettersAsList.contains(letter)) {
                setOfLettersAsList.remove(letter);
            } else {
                return false;
            }
        }

        return true;
    }
}
//END
