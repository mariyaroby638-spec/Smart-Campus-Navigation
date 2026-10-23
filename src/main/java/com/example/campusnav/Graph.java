
package com.example.campusnav;

import java.util.*;

public class Graph {
    private final Map<String, Map<String, Integer>> graph =
            new LinkedHashMap<>();

    public void addPath(String a, String b, int distance) {
        graph.computeIfAbsent(a, k -> new LinkedHashMap<>()).put(b, distance);
        graph.computeIfAbsent(b, k -> new LinkedHashMap<>()).put(a, distance);
    }

    public Set<String> getLocations() {
        return graph.keySet();
    }

    public Map<String, Object> shortestPath(String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            throw new IllegalArgumentException("Invalid location");
        }

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq =
                new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String place : graph.keySet()) {
            dist.put(place, Integer.MAX_VALUE);
        }
        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (var edge : graph.get(current).entrySet()) {
                int nextDist = dist.get(current) + edge.getValue();

                if (nextDist < dist.get(edge.getKey())) {
                    dist.put(edge.getKey(), nextDist);
                    prev.put(edge.getKey(), current);
                    pq.remove(edge.getKey());
                    pq.add(edge.getKey());
                }
            }
        }

        if (dist.get(end) == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("No route found");
        }

        List<String> route = new ArrayList<>();
        for (String at = end; at != null; at = prev.get(at)) {
            route.add(at);
        }
        Collections.reverse(route);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("route", route);
        result.put("distance", dist.get(end));
        return result;
    }
}
