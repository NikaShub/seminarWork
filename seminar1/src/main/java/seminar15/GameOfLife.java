package seminar15;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class GameOfLife {

    private static final int NUM_ROUNDS = 10;

    private static boolean[][] grid;
    private static CyclicBarrier barrier;

    private static class Cell extends Thread {
        private int x, y;

        private boolean isAlive;


        public Cell(int x, int y) {
            isAlive = grid[x][y];
            this.x = x;
            this.y = y;
        }


        @Override
        public void run() {
            for (int i = 0; i < NUM_ROUNDS; i++) {
                boolean nextState = getNextState();

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }

                grid[x][y] = nextState;

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        private boolean getNextState() {
            int countAlive = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int newX = x + i;
                    int newY = y + j;
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY]) {
                        countAlive++;
                    }
                }
            }

            return countAlive == 3 ;// logikebi ra aq aris
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 4, m = 3;
        grid = new boolean[n][m];

        Cell[][] cells = new Cell[n][m];
        barrier = new CyclicBarrier(n * m, () -> {
            System.out.println(Arrays.deepToString(grid));
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               cells[i][j] = new Cell(i, j);
               cells[i][j].start();
            }
        }
    }
}
