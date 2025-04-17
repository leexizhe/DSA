package answers.e_sliding_window;

import java.util.HashSet;

public class E2LongestSubstringWithoutRepeatingCharacters {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of characters in the input string `s`.
     * This is because we iterate through the string using a sliding window approach, processing each character only once.
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n), where n is the number of unique characters in the input string `s`.
     * This is because we use a HashSet to store distinct characters within the sliding window.
     */
    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        // Iterate through the string with a sliding window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Remove characters from the left to maintain uniqueness
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the new character and update max length
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
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
