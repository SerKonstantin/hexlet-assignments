package exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> combinedKeys = new HashSet<>(data1.keySet());
        combinedKeys.addAll(data2.keySet());

        Map<String, String> results = new LinkedHashMap<>();

        for (var key: combinedKeys) {
            if (!data1.containsKey(key)) {
                results.put(key, "added");
            } else if (!data2.containsKey(key)) {
                results.put(key, "deleted");
            } else if (data1.get(key).equals(data2.get(key))) {
                results.put(key, "unchanged");
            } else {
                results.put(key, "changed");
            }
        }

        return results;
    }


    //Another approach just for study purposes, because lesson theme was "using Sets"

//    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
//        Set<String> keys1 = new HashSet<>(data1.keySet());
//        Set<String> keys2 = new HashSet<>(data2.keySet());
//
//        Map<String, String> results = new LinkedHashMap<>();
//
//        Set<String> added = new HashSet<>(keys2);
//        added.removeAll(keys1);
//        for (String key: added) {
//            results.put(key, "added");
//        }
//
//        Set<String> deleted = new HashSet<>(keys1);
//        deleted.removeAll(keys2);
//        for (String key: deleted) {
//            results.put(key, "deleted");
//        }
//
//        Set<String> intersection = new HashSet<>(keys1);
//        intersection.retainAll(keys2);
//        for (String key: intersection) {
//            if (data1.get(key).equals(data2.get(key))) {
//                results.put(key, "unchanged");
//            } else {
//                results.put(key, "changed");
//            }
//        }
//
//        return results;
//    }

}
//END
