package com.company.exercise;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
//        List<Integer> data1 =  List.of(1, 1, 1);
//        List<Integer> data2 =  List.of(1, 1, 0);
//        List<Integer> data3 =  List.of(1, 0, 1);
//        List<List<Integer>> data = List.of(data1, data2, data3);

        List<Integer> data1 =  List.of(1);
        List<List<Integer>> data = List.of(data1);
        System.out.println(largestArea(data));
    }

    public static int largestArea(List<List<Integer>> samples) {
        int n = samples.size();
        if (n == 0) {
            return 0;
        }

        // record the largest matrix filled with 1 found
        int maxLen = 0;

        // initialized dp matrix with 0
        List<List<Integer>> dp = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            List<Integer> item = new ArrayList<>(n + 1);
            for (int j = 0; j < n + 1; j++) {
                item.add(0);
            }
            dp.add(item);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (samples.get(i - 1).get(j - 1) == 1) {
                    int leftMax = dp.get(i).get(j - 1);
                    int upMax = dp.get(i - 1).get(j);
                    int diagonalMax = dp.get(i - 1).get(j - 1);
                    dp.get(i).set(j, Math.min(Math.min(leftMax, upMax), diagonalMax) + 1);

                    if (dp.get(i).get(j) > maxLen) {
                        maxLen = dp.get(i).get(j);
                    }
                }
            }
        }

        return maxLen;
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        Set<String> pKeyWords = Arrays.stream(positiveKeywords.split(" ")).collect(Collectors.toSet());
        Set<String> nKeyWords = Arrays.stream(negativeKeywords.split(" ")).collect(Collectors.toSet());

        List<Node> scores = new ArrayList<>();
        for (int i = 0; i < reviews.size(); i++) {
            int score = 0;
            String review = reviews.get(i);
            List<String> cur = Arrays.stream(review.split(" "))
                    .flatMap(item -> Arrays.stream(item.split("\\.")))
                    .flatMap(item -> Arrays.stream(item.split("!")))
                    .flatMap(item -> Arrays.stream(item.split(",")))
                    .flatMap(item -> Arrays.stream(item.split("'")))
                    .filter(item -> item != null && item != "")
                    .collect(toList());
            for (int j = 0; j < cur.size(); j++) {
                if (pKeyWords.contains(cur.get(j))) {
                    score += 3;
                }

                if (nKeyWords.contains(cur.get(j))) {
                    score -= 1;
                }
            }
            scores.add(new Node(hotelIds.get(i), score));
        }

        List<Node> sorted = scores.stream()
                .sorted(Comparator.comparing(Node::getScore).reversed()
                        .thenComparing(Node::getHotelId)).collect(toList());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(sorted.get(i).getHotelId());
        }

        return result;

    }

    static class Node {
        public Integer hotelId;
        public int score;

        public Integer getHotelId() {
            return hotelId;
        }

        public Integer getScore() {
            return score;
        }

        public Node(Integer hotelId, int score) {
            this.hotelId = hotelId;
            this.score = score;
        }
    }
}



