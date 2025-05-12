package answers.a_arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A6EncodeDecodeStrings {
    /**
     * Key Techniques:
     * ✅ Delimiter-based Encoding → Ensures reliable separation of words.
     * ✅ O(n) Time Complexity → Efficient traversal for both encode and decode.
     * ✅ O(n) Space Complexity → Stores encoded/decrypted results.
     *
     * Time Complexity: O(n)
     * Each character is processed once for encoding and decoding.
     *
     * Space Complexity: O(n)
     * Stores encoded and decoded results efficiently.
     */
    // Step 1: Encode list of strings into a single string with length prefix
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str); // Length#String
        }
        return sb.toString();
    }

    // Step 2: Decode the single string back into original list
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int delimiterIndex = s.indexOf("#", i);
            int length = Integer.parseInt(s.substring(i, delimiterIndex));
            i = delimiterIndex + 1;
            result.add(s.substring(i, i + length));
            i += length; // Move pointer forward
        }

        return result;
    }

    public static void main(String[] args) {
        // Initialize Codec object

        // Test case
        List<String> strs = Arrays.asList("leet", "code", "hello", "world");
        String encoded = encode(strs);
        System.out.println("Encoded: " + encoded); // Example output: "4#leet4#code5#hello5#world"

        List<String> decoded = decode(encoded);
        System.out.println("Decoded: " + decoded); // Example output: ["leet", "code", "hello", "world"]
    }
}
