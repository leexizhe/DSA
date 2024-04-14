package refresher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String strKey = String.valueOf(arr);
            map.computeIfAbsent(strKey, x -> new ArrayList<>());
            map.get(strKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
