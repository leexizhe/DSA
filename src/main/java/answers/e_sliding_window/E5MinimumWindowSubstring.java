package answers.e_sliding_window;

import java.util.HashMap;

public class E5MinimumWindowSubstring {
    /**
     * Key Techniques:
     * ✅ Sliding Window → Expands and contracts dynamically to find the minimum window.
     * ✅ HashMap for Frequency Tracking → Ensures efficient character matching.
     * ✅ O(n) Time Complexity → Processes the string in a single pass.
     *
     * Time Complexity: O(n)
     * We expand and contract the window dynamically, avoiding brute-force O(n²) checks.
     *
     * Space Complexity: O(1)
     * Uses a fixed-size hash map for character frequency tracking.
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, matched = 0, minLength = Integer.MAX_VALUE, startIndex = 0;
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        // Step 1: Expand the right pointer and track character frequency
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowFreq.put(rightChar, windowFreq.getOrDefault(rightChar, 0) + 1);

            if (targetFreq.containsKey(rightChar) && windowFreq.get(rightChar).equals(targetFreq.get(rightChar))) {
                matched++;
            }

            // Step 2: Contract the window when all required characters are matched
            while (matched == targetFreq.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    matched--;
                }

                left++; // Move left pointer forward
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
        System.out.println(minWindow("a", "a")); // Output: "a"
        System.out.println(minWindow("a", "aa")); // Output: ""
    }
}
