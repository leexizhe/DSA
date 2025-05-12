package answers.b_two_pointers;

public class B1ValidPalindrome {
    /**
     * Key Techniques:
     * ✅ Two-Pointer Approach → Efficiently checks palindrome validity.
     * ✅ O(n) Time Complexity → Single-pass character comparison.
     * ✅ O(1) Space Complexity → No extra storage required.
     *
     * Time Complexity: O(n)
     * Each character is processed at most once.
     *
     * Space Complexity: O(1)
     * Only a few extra variables are used for tracking indices.
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++; // Skip non-alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--; // Skip non-alphanumeric

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Mismatched characters
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // Output: true
        System.out.println(isPalindrome("race a car")); // Output: false
        System.out.println(isPalindrome(" ")); // Output: true
    }
}
