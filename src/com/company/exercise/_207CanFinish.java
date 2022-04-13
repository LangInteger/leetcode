package com.company.exercise;

import java.util.*;

public class _207CanFinish {

    private boolean[] visited = null;
    private boolean[] onPath = null;
    private boolean hasCircle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < graph.length; i++) {
            dfs(i, graph);
            if (hasCircle) {
                return false;
            }
        }

        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
        }
        return graph;
    }

    private void dfs(int cur, List<Integer>[] graph) {
        if (onPath[cur]) {
            hasCircle = true;
            return;
        }

        if (visited[cur]) {
            return;
        }

        visited[cur] = true;
        onPath[cur] = true;

        List<Integer> neighbours = graph[cur];
        for (int i = 0; i < neighbours.size(); i++) {
            dfs(neighbours.get(i), graph);
        }

        onPath[cur] = false;
    }

}
