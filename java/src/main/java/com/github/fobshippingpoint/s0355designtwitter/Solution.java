package com.github.fobshippingpoint.s0355designtwitter;

import java.util.*;

public class Solution {

    public static class Twitter {

        private int time;
        private final Map<Integer, List<Long>> tweets;
        private final Map<Integer, Set<Integer>> follows;

        public Twitter() {
            time = 0;
            tweets = new HashMap<>();
            follows = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            var pq = tweets.computeIfAbsent(userId, (k) -> new ArrayList<>());
            time++;
            var packed = ((long) time << 32) | (tweetId & 0xFFFFFFFFL);
            pq.add(packed);
        }

        public List<Integer> getNewsFeed(int userId) {
            var latest = new PriorityQueue<Long>();

            addLatestTweets(latest, tweets.get(userId));
            var followees = follows.get(userId);
            if (followees != null) {
                for (var followeeId : followees) {
                    addLatestTweets(latest, tweets.get(followeeId));
                }
            }

            var feed = new ArrayDeque<Integer>();
            while (!latest.isEmpty()) {
                feed.addFirst((int) (long) latest.remove());
            }
            return new ArrayList<>(feed);
        }

        private void addLatestTweets(PriorityQueue<Long> latest, List<Long> userTweets) {
            if (userTweets == null) {
                return;
            }
            for (var tweet : userTweets) {
                latest.offer(tweet);
                if (latest.size() > 10) {
                    latest.remove();
                }
            }
        }

        public void follow(int followerId, int followeeId) {
            follows.computeIfAbsent(followerId, (k) -> new HashSet<>()).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            var set = follows.get(followerId);
            if (set != null) {
                set.remove(followeeId);
            }
        }

    }

}
