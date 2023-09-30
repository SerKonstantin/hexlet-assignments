package exercise;

//import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.serialize;
import static exercise.Utils.unserialize;
import static exercise.Utils.writeFile;
import static exercise.Utils.readFile;

// BEGIN
public class FileKV implements KeyValueStorage {
    String filepath;

    public FileKV(String filepath, Map<String, String> initMap) {
        this.filepath = filepath;
        Map<String, String> storage = new HashMap<>(initMap);
        String content = serialize(storage);
        writeFile(filepath, content);
    }

    @Override
    public void set(String key, String value) {
        String json = readFile(filepath);
        Map<String, String> data = unserialize(json);
        data.put(key, value);
        String content = serialize(data);
        writeFile(filepath, content);
    }

    @Override
    public void unset(String key) {
        String json = readFile(filepath);
        Map<String, String> data = unserialize(json);
        data.remove(key);
        String content = serialize(data);
        writeFile(filepath, content);
    }

    @Override
    public String get(String key, String defaultValue) {
        String json = readFile(filepath);
        Map<String, String> data = unserialize(json);
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String json = readFile(filepath);
        return unserialize(json);
    }
}
// END
