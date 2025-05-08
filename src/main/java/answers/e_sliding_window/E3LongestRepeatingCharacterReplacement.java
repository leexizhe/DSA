package answers.e_sliding_window;

public class E3LongestRepeatingCharacterReplacement {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the length of the input string `s`.
     * We use the sliding window technique to traverse the string while dynamically adjusting the window size.
     *
     * Space Complexity: O(1)
     * The space complexity is O(1), as we only use an array of fixed size (26) to track character frequencies.
     */
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Check if window size exceeds the allowed replacements
            while (right - left + 1 - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2)); // Output: 4
        System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
    }
}
