package Arrays_Hashing;

import java.util.*;

public class GroupAnagrams {
    // time O(n*m)
    // space O(n*m) where m is the number of characters
    // hashmap

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new LinkedList<>();

        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            String strKey = String.valueOf(arr);
            map.computeIfAbsent(strKey, k -> new ArrayList<>());
            map.get(strKey).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strings1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strings2 = {"eat", "tea", "ate"};
        String[] strings3 = {"a"};
        System.out.println(groupAnagrams(strings1));
        System.out.println(groupAnagrams(strings2));
        System.out.println(groupAnagrams(strings3));
    }
}
