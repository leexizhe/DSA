package answers.f_linked_list;

import java.util.HashMap;

public class F9LRUCache {
    /**
     * Time Complexity: O(1)
     * Both `get()` and `put()` operations run in O(1) time due to efficient usage of HashMap and Doubly Linked List.
     *
     * Space Complexity: O(capacity)
     * The space complexity is O(capacity) since we store at most `capacity` key-value pairs in the cache.
     */
    static class Node {
        int key, val;
        Node prev, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    static class LRUCache {
        private int capacity;
        private HashMap<Integer, Node> cache;
        private Node left, right; // Dummy nodes for easy eviction handling

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            Node prev = right.prev;
            prev.next = node;
            node.prev = prev;
            node.next = right;
            right.prev = node;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;

            Node node = cache.get(key);
            remove(node);
            insert(node); // Move accessed node to the most recent position
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                remove(cache.get(key));
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);

            // Evict least recently used node if capacity is exceeded
            if (cache.size() > capacity) {
                Node lru = left.next;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 10);
        lruCache.put(2, 20);
        System.out.println(lruCache.get(1)); // Output: 10

        lruCache.put(3, 30); // Removes least recently used key 2
        System.out.println(lruCache.get(2)); // Output: -1 (not found)

        lruCache.put(4, 40); // Removes least recently used key 1
        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        System.out.println(lruCache.get(3)); // Output: 30
        System.out.println(lruCache.get(4)); // Output: 40
    }
}
