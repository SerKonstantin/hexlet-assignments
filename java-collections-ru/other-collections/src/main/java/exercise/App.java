package exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


// BEGIN
public class App {
    // Made everything like this because lesson theme was "using Sets"
    // From the first glance it would be simpler to merge keys in one list then do if/else checks with contains

    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys1 = new HashSet<>(data1.keySet());
        Set<String> keys2 = new HashSet<>(data2.keySet());

        Map<String, String> results = new LinkedHashMap<>();

        Set<String> added = new HashSet<>(keys2);
        added.removeAll(keys1);
        for (String key: added) {
            results.put(key, "added");
        }

        Set<String> deleted = new HashSet<>(keys1);
        deleted.removeAll(keys2);
        for (String key: deleted) {
            results.put(key, "deleted");
        }

        Set<String> intersection = new HashSet<>(keys1);
        intersection.retainAll(keys2);
        for (String key: intersection) {
            if (data1.get(key).equals(data2.get(key))) {
                results.put(key, "unchanged");
            } else {
                results.put(key, "changed");
            }
        }

        return results;
    }
}
//END
