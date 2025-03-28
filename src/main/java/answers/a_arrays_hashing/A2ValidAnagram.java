package answers.a_arrays_hashing;

import java.util.Arrays;

public class A2ValidAnagram {
    /**
     * Time Complexity: O(n)
     * The function iterates through the characters of the strings 's' and 't' once.
     * Populating the 'count' array and verifying its values each take O(n), where 'n' is the length of the strings.
     * Thus, the total time complexity is O(n).
     *
     * Space Complexity: O(1)
     * The function uses a fixed-size integer array of length 26 to store character counts.
     * Since the array size is constant and does not scale with input size, the space complexity is O(1).
     */
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count occurrences of each character
        int[] count = new int[26]; // Fixed size for 26 lowercase English letters

        // Increment count for characters in 's' and decrement for characters in 't'
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int num : count) {
            if (num != 0) {
                return false; // If any count is not zero, 's' and 't' are not anagrams
            }
        }

        // If all counts are zero, the strings are anagrams
        return true;
    }

    /**
     * Time Complexity: O(n log n)
     * The function sorts both strings by converting them into character arrays.
     * Sorting each array takes O(n log n) time, where 'n' is the length of the strings.
     * After sorting, comparing the arrays using Arrays.equals() takes O(n).
     * Thus, the total time complexity is O(n log n).
     *
     * Space Complexity: O(n)
     * Two new character arrays are created to hold the characters of 's' and 't'.
     * The space used by these arrays is proportional to the size of the strings.
     * Sorting may also require additional memory depending on the sorting algorithm used.
     * Hence, the overall space complexity is O(n).
     */
    private static boolean isAnagramSorted(String s, String t) {
        // Convert strings to character arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Sort both character arrays
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // Compare sorted arrays
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagramSorted("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
        System.out.println(isAnagramSorted("rat", "cat"));
    }
}
