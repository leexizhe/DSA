package answers.e_sliding_window;

import java.util.HashSet;

public class E2LongestSubstringWithoutRepeatingCharacters {
    /**
     * Key Techniques:
     * ✅ Sliding Window → Expands and contracts dynamically for efficiency.
     * ✅ O(n) Time Complexity → Processes characters in a single pass.
     * ✅ O(1) Space Complexity → Uses only a fixed-size character set.
     *
     * Time Complexity: O(n)
     * We traverse the string once, expanding and contracting the window dynamically.
     *
     * Space Complexity: O(1)
     * Uses at most 26 or 128 characters (depending on the encoding).
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        // Step 1: Expand the right pointer and track unique characters
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // Remove leftmost character
                left++; // Shrink the window
            }

            set.add(s.charAt(right)); // Add current character
            maxLength = Math.max(maxLength, right - left + 1); // Update max length
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3 ("abc")
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1 ("b")
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3 ("wke")
    }
}
