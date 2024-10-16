package exercise;

import jdk.jshell.execution.Util;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.deserialize;
import static exercise.Utils.readFile;
import static exercise.Utils.serialize;
import static exercise.Utils.writeFile;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String pathFile;

    public FileKV(String path, Map<String, String> map) {
        this.pathFile = path;
        writeFile(pathFile, serialize(map));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> storageKV = new HashMap<>(deserialize(readFile(pathFile)));
        storageKV.put(key, value);
        writeFile(pathFile, serialize(storageKV));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> storageKV = new HashMap<>(deserialize(readFile(pathFile)));
        String result = storageKV.get(key);
        if ( result == null) {
            result = defaultValue;
        }
        return result;
    }

    @Override
    public void unset(String key) {
        Map<String, String> storageKV = new HashMap<>(deserialize(readFile(pathFile)));
        storageKV.remove(key);
        writeFile(pathFile, serialize(storageKV));
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(deserialize(readFile(pathFile)));
    }
}
// END
