package answers.f_linked_list;

import java.util.HashMap;

public class F9LRUCache {
    /**
     * Key Techniques:
     * ✅ HashMap for O(1) lookup.
     * ✅ Doubly Linked List for O(1) insert & remove.
     * ✅ O(1) Time Complexity for get and put operations.
     *
     * Time Complexity: O(1)
     * Both `get` and `put` operations execute in constant time.
     *
     * Space Complexity: O(capacity)
     * The cache stores up to `capacity` elements.
     */
    static class LRUCache {
        private final int capacity;
        private final HashMap<Integer, Node> cache;
        private final Node head, tail;

        private static class Node {
            int key, value;
            Node prev, next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>(capacity);
            this.head = new Node(-1, -1); // Dummy head
            this.tail = new Node(-1, -1); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) return -1;

            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);

                if (cache.size() > capacity) {
                    removeLRU();
                }
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void removeLRU() {
            Node lru = tail.prev;
            cache.remove(lru.key);
            removeNode(lru);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Output: 1
        cache.put(3, 3); // Removes key 2
        System.out.println(cache.get(2)); // Output: -1
        cache.put(4, 4); // Removes key 1
        System.out.println(cache.get(1)); // Output: -1
        System.out.println(cache.get(3)); // Output: 3
        System.out.println(cache.get(4)); // Output: 4
    }
}
