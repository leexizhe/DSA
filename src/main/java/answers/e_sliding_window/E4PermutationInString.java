package answers.e_sliding_window;

import java.util.Arrays;

public class E4PermutationInString {
    /**
     * Key Techniques:
     * ✅ Sliding Window → Efficient substring scanning.
     * ✅ O(n) Time Complexity → Single traversal of both strings.
     * ✅ O(1) Space Complexity → Uses fixed-size character frequency arrays.
     *
     * Time Complexity: O(n)
     * We process `s2` once while maintaining frequency tracking, making it linear.
     *
     * Space Complexity: O(1)
     * Fixed-size character arrays for frequency tracking ensure constant space usage.
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // Step 1: Populate frequency array for s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Step 2: Iterate through s2 using a sliding window of length s1
        for (int i = 0; i < s2.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++; // Add current character

            // Remove the leftmost character when window exceeds s1 length
            if (i >= s1.length()) {
                s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            }

            // Step 3: Check if frequency arrays match (valid permutation)
            if (Arrays.equals(s1Freq, s2Freq)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // Output: true
        System.out.println(checkInclusion("ab", "eidboaoo")); // Output: false
    }
}
