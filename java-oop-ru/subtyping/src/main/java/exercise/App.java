package exercise;

//import java.util.Map;
import java.util.Map.Entry;
//import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        for (Entry<String, String> entry : data.toMap().entrySet()) {
            data.set(entry.getValue(), entry.getKey());
            data.unset(entry.getKey());
        }
    }
}
// END
