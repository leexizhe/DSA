package answers.i_heap;

import java.util.*;

public class I6Twitter {
    /**
     * Key Techniques:
     * ✅ MaxHeap (PriorityQueue) → Efficient retrieval of latest tweets
     * ✅ HashMap for follow relationships → Fast lookups and updates
     * ✅ Separate tweet storage per user → Avoids global sorting overhead
     * Time Complexity:
     * - postTweet() → O(1) (Constant time insertion)
     * - getNewsFeed() → O(N log K) (Heap operations, where N is followed users)
     * - follow() / unfollow() → O(1) (Set operations)
     * Space Complexity: O(N + T), where N is the number of users and T is the number of tweets stored
     */
    private static int timestamp = 0;

    private Map<Integer, Set<Integer>> followers; // Follow relationships
    private Map<Integer, List<Tweet>> tweets; // User tweets

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public I6Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    /**
     * Post a tweet → O(1)
     */
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    /**
     * Get News Feed → O(N log K)
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        followers.putIfAbsent(userId, new HashSet<>());
        followers.get(userId).add(userId); // Include own tweets

        for (int followeeId : followers.get(userId)) {
            if (tweets.containsKey(followeeId)) {
                pq.addAll(tweets.get(followeeId));
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty() && feed.size() < 10) {
            feed.add(pq.poll().id);
        }

        return feed;
    }

    /**
     * Follow user → O(1)
     */
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    /**
     * Unfollow user → O(1)
     */
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

    public static void main(String[] args) {
        I6Twitter twitter = new I6Twitter();
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);
        twitter.follow(2, 1);
        twitter.postTweet(2, 201);

        System.out.println("User 2's News Feed: " + twitter.getNewsFeed(2)); // Expected: [201, 102, 101]
        twitter.unfollow(2, 1);
        System.out.println("User 2's News Feed after unfollowing: " + twitter.getNewsFeed(2)); // Expected: [201]
    }
}
