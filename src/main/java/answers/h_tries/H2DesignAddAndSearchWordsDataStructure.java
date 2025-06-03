package answers.h_tries;

import java.util.HashMap;

public class H2DesignAddAndSearchWordsDataStructure {
    private TrieNode root;

    // Constructor initializes an empty Trie
    public H2DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    // Adds a word to the Trie
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            cur.child.putIfAbsent(c, new TrieNode());
            cur = cur.child.get(c);
        }
        cur.isEnd = true;
    }

    // Searches for a word in the Trie, allowing '.' as a wildcard
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // Recursive helper method for searching with wildcard support
    private boolean dfs(String word, int index, TrieNode node) {
        TrieNode cur = node;
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                // Wildcard case: Check all possible children
                for (TrieNode child : cur.child.values()) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true; // Immediately return upon success
                    }
                }
                return false; // If no match found, return false
            } else {
                // Normal case: Follow Trie path
                if (!cur.child.containsKey(c)) {
                    return false;
                }
                cur = cur.child.get(c);
            }
        }
        return cur.isEnd; // Check if we've reached a valid word end
    }

    // TrieNode class definition
    private static class TrieNode {
        HashMap<Character, TrieNode> child = new HashMap<>();
        boolean isEnd = false;
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        H2DesignAddAndSearchWordsDataStructure wordDictionary = new H2DesignAddAndSearchWordsDataStructure();

        // Adding words to the dictionary
        wordDictionary.addWord("apple");
        wordDictionary.addWord("banana");
        wordDictionary.addWord("grape");

        // Searching words
        System.out.println(wordDictionary.search("apple")); // true
        System.out.println(wordDictionary.search("app..")); // true (wildcard match)
        System.out.println(wordDictionary.search("banana")); // true
        System.out.println(wordDictionary.search("gr.pe")); // true (wildcard match)
        System.out.println(wordDictionary.search("orange")); // false
    }
}
