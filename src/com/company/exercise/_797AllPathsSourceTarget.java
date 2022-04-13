package com.company.exercise;

import java.util.*;

public class _797AllPathsSourceTarget {

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        LinkedList<Integer> track = new LinkedList<>();
        track.addLast(0);

        dfs(0, graph, track);

        return result;
    }

    private void dfs(int node, int[][] graph, LinkedList<Integer> track) {
        int[] neighbours = graph[node];
        for (int i = 0; i < neighbours.length; i++) {
            track.addLast(neighbours[i]);

            if (neighbours[i] == graph.length - 1) {
                result.add(new LinkedList<>(track));
                track.removeLast();
            } else {
                dfs(neighbours[i], graph, track);
                track.removeLast();
            }
        }
    }

}
