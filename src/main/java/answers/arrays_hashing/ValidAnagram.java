package answers.arrays_hashing;

import java.util.Arrays;

public class ValidAnagram {
    /**
     * Time Complexity: O(n)
     * Iterating through both strings to count characters takes O(n), where n is the length of the strings.
     *
     * Space Complexity: O(1)
     * The size of the count array (26 elements) is constant and does not depend on the input size.
     * Thus, the space complexity is constant.
     */
    private static boolean isAnagram(String s, String t) {
        // time O(n)
        // space O(n)
        // use another array

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }

        for (int n : alphabets) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram_sorted(String s, String t) {
        // time O(n log n)
        // space O(n)
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram_sorted("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
        System.out.println(isAnagram_sorted("rat", "cat"));
    }
}
