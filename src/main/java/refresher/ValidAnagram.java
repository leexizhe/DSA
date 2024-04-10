package refresher;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabets = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabets[(s.charAt(i) - 'a')]++;
            alphabets[(t.charAt(i) - 'a')]--;
        }

        for (int character : alphabets) {
            if (0 != character) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "cat"));
    }
}
