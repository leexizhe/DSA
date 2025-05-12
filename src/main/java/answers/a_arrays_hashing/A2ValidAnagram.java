package answers.a_arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class A2ValidAnagram {
    /**
     * Key Techniques:
     * ✅ Sorting or HashMap → Efficiently checks character distribution.
     * ✅ O(n log n) or O(n) Time Complexity → Depending on approach used.
     * ✅ O(n) or O(1) Space Complexity → Depending on approach used.
     *
     * Time Complexity:
     * - Sorting Approach: O(n log n)
     * - HashMap Approach: O(n)
     *
     * Space Complexity:
     * - Sorting Approach: O(1) (In-place sorting)
     * - HashMap Approach: O(n) (Stores character frequencies)
     */

    // Approach 1: Sorting
    public static boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    // Approach 2: HashMap (Better for efficiency)
    public static boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagramSorting("anagram", "nagaram"));
        System.out.println(isAnagramHashMap("anagram", "nagaram"));
        System.out.println(isAnagramSorting("rat", "cat"));
        System.out.println(isAnagramHashMap("rat", "cat"));
    }
}
