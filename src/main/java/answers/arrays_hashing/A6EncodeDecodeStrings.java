package answers.arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A6EncodeDecodeStrings {
    /**
     * Time Complexity: O(n)
     * - Encoding: Constructing the encoded string takes O(n), where `n` is the total number of characters across all strings.
     * - Decoding: Splitting and parsing the encoded string also takes O(n).
     *
     * Space Complexity: O(n)
     * - The space complexity is O(n) because of the additional space required to store the encoded or decoded strings.
     */

    // Encodes a list of strings to a single string
    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            // Prefix each string with its length and a delimiter (e.g., ":")
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings
    public static List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Read the length of the string up to the delimiter ("#")
            int delimiter = i;
            while (s.charAt(delimiter) != '#') {
                delimiter++;
            }
            int length = Integer.parseInt(s.substring(i, delimiter));
            i = delimiter + 1;

            // Extract the actual string of the given length
            String str = s.substring(i, i + length);
            decoded.add(str);
            i += length; // Move the pointer forward
        }

        return decoded;
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
