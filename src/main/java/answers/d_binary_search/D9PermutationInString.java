package answers.d_binary_search;

import java.util.Arrays;

public class D9PermutationInString {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the length of the input string `s2`.
     * We slide a window of size `s1.length()` across `s2`, updating character frequencies dynamically.
     *
     * Space Complexity: O(1)
     * The space complexity is O(1) because we only use two fixed-size arrays (26 elements each) to track character frequencies.
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : s1.toCharArray()) s1Freq[c - 'a']++;

        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            windowFreq[s2.charAt(right) - 'a']++;

            // Maintain a window of size s1.length()
            if (right - left + 1 > s1.length()) {
                windowFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            // Compare frequency arrays
            if (Arrays.equals(s1Freq, windowFreq)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // Output: true
        System.out.println(checkInclusion("ab", "eidboaoo")); // Output: false
    }
}
