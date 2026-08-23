package com.github.fobshippingpoint.s0332reconstructitinerary;

import java.util.*;


public class Solution {

    private final Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private final LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (var ticket : tickets) {
            graph.computeIfAbsent(ticket.getFirst(), _ -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String airport) {
        var destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            var nextAirport = destinations.remove();
            dfs(nextAirport);
        }

        itinerary.addFirst(airport);
    }

}
