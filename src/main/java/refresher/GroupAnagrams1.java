package refresher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String string = String.valueOf(arr);
            map.computeIfAbsent(string, x -> new ArrayList<>());
            map.get(string).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
