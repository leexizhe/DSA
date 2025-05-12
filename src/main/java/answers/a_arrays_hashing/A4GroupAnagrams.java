package answers.a_arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class A4GroupAnagrams {
    /**
     * Key Techniques:
     * ✅ HashMap → Efficiently groups anagrams using character frequency as key.
     * ✅ O(n * k) Time Complexity → Avoids sorting overhead.
     * ✅ O(n) Space Complexity → Stores grouped words efficiently.
     *
     * Time Complexity: O(n * k)
     * Each word is processed once, and counting characters runs in O(k).
     *
     * Space Complexity: O(n)
     * Stores all grouped anagrams efficiently.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] arr = new char[26]; // Fixed size for lowercase letters
            for (char c : str.toCharArray()) {
                arr[c - 'a']++; // Character frequency tracking
            }

            String strKey = Arrays.toString(arr); // Convert frequency array to string key

            map.computeIfAbsent(strKey, k -> new ArrayList<>()).add(str);
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
