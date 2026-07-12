package com.github.fobshippingpoint.s0355designtwitter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testTwitterV1() {
        var twitter = new Solution.Twitter();

        twitter.postTweet(1, 5);
        assertEquals(List.of(5), twitter.getNewsFeed(1),
                "Should include the user's own tweet");

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        assertEquals(List.of(6, 5), twitter.getNewsFeed(1),
                "Should include followed users' tweets from newest to oldest");

        twitter.unfollow(1, 2);
        assertEquals(List.of(5), twitter.getNewsFeed(1),
                "Should exclude an unfollowed user's tweets");
    }

}
