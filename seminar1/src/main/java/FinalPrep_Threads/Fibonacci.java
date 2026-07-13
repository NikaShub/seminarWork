package FinalPrep_Threads;

import java.util.concurrent.Semaphore;

public class Fibonacci {
    private final int k;
    private final Semaphore semaphore;


    public Fibonacci(int k, int maxNum) {
        this.k = k;
        this.semaphore = new Semaphore(maxNum);
    }

    public long fib(int n) {
        if (n < k) {
            return 1;
        }

        Thread[] threads = new Thread[k];
        long[] results = new long[k];

        for (int i = 0; i < k; i++) {
            final int targetN = n - (i + 1);
            final int index = i;

            if (semaphore.tryAcquire()) {
                threads[i] = new Thread(() -> {
                    try {
                        results[index] = fib(targetN);
                    } finally {
                        semaphore.release();
                    }
                });
                threads[i].start();
            } else {
                threads[i] = null;
                results[index] = fib(targetN);
            }
        }
        for (int i = 0; i < k; i++) {
            if (threads[i] != null) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        long totalSum = 0;
        for (long res : results) {
            totalSum += res;
        }

        return totalSum;
    }
}
