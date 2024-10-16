package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        String t;
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        // Получение значения по ключу
        t = storage.get("key", "default"); // "10"
        t = storage.get("unknown", "default"); // "default"
        // Установка нового значения
        storage.set("key2", "value2");
        t = storage.get("key2", "default"); // "value2"
        // Удаление ключа
        storage.unset("key2");
        t = storage.get("key2", "default"); // "default"
        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        System.out.println(data); // => {key=10};
        KeyValueStorage tt = new InMemoryKV(Map.of("key", "value"));
        tt.set("key2", "value2");
        swapKeyValue(tt);
    }

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> result = new HashMap<>();
        Map<String, String> map = new HashMap<>(storage.toMap());
        for (Map.Entry<String, String> swap : map.entrySet()) {
            storage.unset(swap.getKey());
            storage.set(swap.getValue(), swap.getKey());
        }


//        ***
//        Map<String, String> swapped = map.entrySet().stream()
//                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
//        ***
//        for (Map<String, String> swap : map.entrySet() {
//            result.put(swap.getValue(), swap.getKey());
//        }
    }

}
// END
