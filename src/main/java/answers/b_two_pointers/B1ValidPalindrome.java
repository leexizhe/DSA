package answers.b_two_pointers;

public class B1ValidPalindrome {
    /**
     * Time Complexity: O(n)
     * - The string is processed once to filter and normalize the characters, which takes O(n).
     * - The two-pointer comparison also traverses the string once, taking O(n).
     * - Therefore, the total time complexity is O(n).
     *
     * Space Complexity: O(1)
     * - Only a constant amount of extra space is used for pointers and variables, excluding the input string.
     * - Thus, the space complexity is O(1).
     */
    public static boolean isPalindrome(String s) {
        // Step 1: Convert the string to lowercase and use two pointers
        int left = 0;
        int right = s.length() - 1;

        // Step 2: Two-pointer approach to check for palindrome
        while (left < right) {
            // Skip non-alphanumeric characters for the left pointer
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric characters for the right pointer
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Check if the characters match
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        // Return true if no mismatches are found
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // Output: true
        System.out.println(isPalindrome("race a car")); // Output: false
        System.out.println(isPalindrome(" ")); // Output: true
    }
}
