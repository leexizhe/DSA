package answers.e_sliding_window;

import java.util.HashMap;

public class E5MinimumWindowSubstring {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the length of the input string `s`.
     * The sliding window ensures we efficiently track character frequencies while minimizing redundant checks.
     *
     * Space Complexity: O(1)
     * The space complexity is O(1) since we only store character frequencies in fixed-size HashMaps (limited to 26 characters for lowercase).
     */
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Store frequency count of characters in t
        HashMap<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        int left = 0, matchedChars = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            // If character frequency matches, increment matched count
            if (targetFreq.containsKey(rightChar) &&
                    windowFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                matchedChars++;
            }

            // Shrink the window when all required characters are matched
            while (matchedChars == targetFreq.size()) {
                // Update minimum substring length
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                // Reduce the count of leftmost character
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                // If a required character count drops below target, decrement matched count
                if (targetFreq.containsKey(leftChar) &&
                        windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    matchedChars--;
                }

                left++; // Move left pointer forward
            }
        }

        // Return shortest valid substring or empty if none found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("a", "a")); // Output: "a"
        System.out.println(minWindow("a", "aa")); // Output: ""
    }
}
