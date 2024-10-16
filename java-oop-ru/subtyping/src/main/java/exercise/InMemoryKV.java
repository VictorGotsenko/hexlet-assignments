package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> kv;

    public InMemoryKV(Map<String, String> inKV) {
        this.kv = new HashMap<>(inKV);
    }

    @Override
    public void set (String key, String value) {
        kv.put(key, value);
    }

    @Override
    public void unset(String key) {
        kv.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        String result = kv.get(key);
        if ( result == null) {
            result = defaultValue;
        }
        return result;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.kv);
    }
}
// END
