package com.company.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintABC {

    private static volatile char current = 'a';

    public static void main(String[] args) {

        // 启用线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 先从0，偶数开始
        executorService.execute(() -> {
            while (current <= 'c') {
                if (current == 'a') {
                    System.out.println("Thread 1 " + current);
                    current = 'b';
                }
            }
        });
        executorService.execute(() -> {
            while (current <= 'c') {
                if (current == 'b') {
                    System.out.println("Thread 2 " + current);
                    current = 'c';
                }
            }
        });
        executorService.execute(() -> {
            while (current <= 'c') {
                if (current == 'c') {
                    System.out.println("Thread 3 " + current);
                    current = 'd';
                }
            }
        });
        executorService.shutdown();
    }
}
