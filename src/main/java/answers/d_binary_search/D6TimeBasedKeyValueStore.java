package answers.d_binary_search;

import java.util.HashMap;
import java.util.TreeMap;

public class D6TimeBasedKeyValueStore {
    /**
     * Key Techniques:
     * ✅ HashMap + TreeMap → Ensures efficient insertion and retrieval.
     * ✅ O(log n) Time Complexity → Binary search on timestamps.
     * ✅ O(n) Space Complexity → Stores all values efficiently.
     *
     * Time Complexity:
     * - `set()` → O(1) (Direct insertion into TreeMap)
     * - `get()` → O(log n) (Binary search on timestamp values)
     *
     * Space Complexity: O(n)
     * Stores all key-value pairs efficiently.
     */
    static class TimeMap {
        private HashMap<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";

            TreeMap<Integer, String> timeMap = map.get(key);
            Integer floorKey = timeMap.floorKey(timestamp);

            return floorKey != null ? timeMap.get(floorKey) : "";
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // Output: "bar"
        System.out.println(timeMap.get("foo", 3)); // Output: "bar"
        timeMap.set("foo", "baz", 4);
        System.out.println(timeMap.get("foo", 4)); // Output: "baz"
        System.out.println(timeMap.get("foo", 5)); // Output: "baz"
    }
}
