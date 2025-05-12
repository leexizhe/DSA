package answers.e_sliding_window;

public class E3LongestRepeatingCharacterReplacement {
    /**
     * Key Techniques:
     * ✅ Sliding Window → Dynamically expands and contracts for efficiency.
     * ✅ O(n) Time Complexity → Processes the string in a single pass.
     * ✅ O(1) Space Complexity → Uses a fixed-size frequency array.
     *
     * Time Complexity: O(n)
     * We traverse the string once, adjusting the window dynamically.
     *
     * Space Complexity: O(1)
     * Uses a fixed-size array to track character frequencies.
     */
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        int[] freq = new int[26]; // Frequency array for tracking character counts
        int maxCount = 0, left = 0, maxLength = 0;

        // Step 1: Expand the right pointer and track character frequencies
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

            // Step 2: Shrink the window if replacements exceed allowed k
            while ((right - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++; // Move left pointer forward
            }

            maxLength = Math.max(maxLength, right - left + 1); // Update max length
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // Output: 4
        System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
    }
}
