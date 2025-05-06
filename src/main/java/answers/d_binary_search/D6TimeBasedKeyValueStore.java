package answers.d_binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class D6TimeBasedKeyValueStore {
    /**
     * Time Complexity:
     * - `set(key, value, timestamp)`: O(1), as inserting into a HashMap and List is constant time.
     * - `get(key, timestamp)`: O(log n), using binary search on the stored timestamps.
     *
     * Space Complexity: O(n)
     * - We store key-value pairs along with timestamps, leading to linear space usage.
     */
    static class TimeMap {
        private HashMap<String, List<Pair>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";

            List<Pair> pairs = map.get(key);
            int left = 0;
            int right = pairs.size() - 1;
            String result = "";

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (pairs.get(mid).timestamp <= timestamp) {
                    result = pairs.get(mid).value;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return result;
        }
    }

    static class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
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
