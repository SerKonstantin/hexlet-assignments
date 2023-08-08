package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List findWhere(List<Map<String, String>> books, Map<String, String> searchRequest) {
        List<String> valuesToCheck = new ArrayList<>();
        List<Map<String, String>> output = new ArrayList<>();

        for (Map.Entry<String, String> pair: searchRequest.entrySet()) {
            valuesToCheck.add(pair.getValue());
        }

        for (Map<String, String> book: books) {
            if (book.values().containsAll(valuesToCheck)) {
                output.add(book);
            }
        }

        return output;
    }
}
//END
