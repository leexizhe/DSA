package answers.h_tries;

public class H1ImplementTrie {
    /**
     * Key Techniques:
     * ✅ Uses a nested Node class for structured data storage.
     * ✅ Efficient O(N) insert & search operations.
     * ✅ Supports prefix searches with O(N) complexity.
     * ✅ Easy to extend for autocomplete, word suggestion, etc.
     *
     * Time Complexity: O(N) for insert, search, and prefix lookup
     * Space Complexity: O(N * M) where N is the number of words, M is the average length.
     */
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Stores 26 lowercase letters
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public H1ImplementTrie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if any word starts with a given prefix
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    // Helper method to traverse Trie nodes
    private TrieNode getNode(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        H1ImplementTrie trie = new H1ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }
}
