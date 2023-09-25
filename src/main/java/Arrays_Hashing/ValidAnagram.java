package Arrays_Hashing;

import java.util.Arrays;

public class ValidAnagram {
    private static boolean isAnagram(String s, String t) {
        // time O(n)
        // space O(n)
        

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }

        for (int n : alphabets) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram_sorted(String s, String t) {
        // time O(n log n)
        // space O(n)
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram_sorted("anagram","nagaram"));
        System.out.println(isAnagram("rat","cat"));
        System.out.println(isAnagram_sorted("rat","cat"));
    }

}
