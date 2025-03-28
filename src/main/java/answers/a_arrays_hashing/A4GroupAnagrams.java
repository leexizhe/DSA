package answers.a_arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class A4GroupAnagrams {
    /**
     * Time Complexity: O(n * k)
     * The time complexity of this solution is O(n * k), where:
     * - `n` is the number of strings in the input array `strs`.
     * - `k` is the average length of each string.
     * This is because we iterate through all the strings, and for each string, we traverse its characters to calculate the frequency array, which takes O(k).
     *
     * Space Complexity: O(n * k)
     * The space complexity is O(n * k) because we store `n` frequency keys of size 26 (fixed for lowercase English letters) and `n` strings in the HashMap.
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to group anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // Loop through the input array
        for (String str : strs) {
            // Initialize a frequency array for each string
            char[] arr = new char[26]; // Fixed size for lowercase English letters

            // Calculate the frequency of each character
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }

            // Convert the frequency array to a key string
            String strKey = String.valueOf(arr);

            // Add the string to the group corresponding to the frequency key
            map.computeIfAbsent(strKey, k -> new ArrayList<>());
            map.get(strKey).add(str);
        }

        // Return the grouped anagrams as a list of lists
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
