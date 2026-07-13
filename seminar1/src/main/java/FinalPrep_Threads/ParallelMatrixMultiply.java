package FinalPrep_Threads;

public class ParallelMatrixMultiply{
    public static int[][] parallelMatrixMultiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        int[][] C = new int[m][p];

        Object[][] locks = new Object[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                locks[i][j] = new Object();
            }
        }

        Thread[] threads = new Thread[m * n * p];
        int threadIndex = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    final int row = i;
                    final int col = j;
                    final int inner = k;
                    threads[threadIndex] = new Thread(() -> {
                        int product = A[row][inner] * B[inner][col];

                        synchronized (locks[row][col]) {
                            C[row][col] += product;
                        }
                    });

                    threads[threadIndex].start();
                    threadIndex++;
                }
            }
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return C;
    }
}
