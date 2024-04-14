package answers.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /**
     * Time Complexity: O(n * k)
     * Iterating through each string in the input array strs and counting the frequency of each character in it takes O(n * k) time,
     * where n is the number of strings in the array and k is the maximum length of a string.
     * The usage of computeIfAbsent method takes constant time O(1) for each string.
     *
     * Space Complexity: O(n * k)
     * The space complexity of this solution is O(n * k), where n is the number of strings in the input array strs, and k is the maximum length of a string.
     * This space is occupied by the HashMap map, where we store the unique keys and lists of anagrams.
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

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
