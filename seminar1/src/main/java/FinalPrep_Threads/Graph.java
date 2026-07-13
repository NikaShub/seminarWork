package FinalPrep_Threads;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

interface Node {
    int getWeight();
    String[] getNeighbors();
}

interface GraphMeth {
    Node getNodeInfo(String nodeId);
}

public class Graph {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    private static int totalWeight = 0;

    private static int activeThreads = 0;

    private static boolean isFinished = false;

    int getOverallWeight(GraphMeth graphMeth,
                                      int numThreads) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        totalWeight = 0;
        activeThreads = 0;
        isFinished = false;

        queue.add("START");
        visited.add("START");

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread( ()-> {
                while (true) {
                    String currentNodeId = null;

                    lock.lock();
                    try {
                        while (queue.isEmpty() && !isFinished) {
                            if (activeThreads == 0) {
                                isFinished = true;
                                condition.signalAll();
                                break;
                            }
                            try {
                                condition.await();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }

                        if (isFinished) {
                            break;
                        }

                        currentNodeId = queue.poll();
                        activeThreads++;

                    } finally {
                        lock.unlock();
                    }

                    if (currentNodeId != null) {
                        Node node = graphMeth.getNodeInfo(currentNodeId);
                        int weight = node.getWeight();
                        String[] neighbors = node.getNeighbors();

                        lock.lock();
                        try {
                            totalWeight += weight;
                            for (String neighbor : neighbors) {
                                if (!visited.contains(neighbor)) {
                                    visited.add(neighbor);
                                    queue.add(neighbor);
                                    condition.signal();
                                }
                            }

                            activeThreads--;
                            condition.signalAll();

                        } finally {
                            lock.unlock();
                        }
                    }
                }
            }

            );
            threads[i].start();
        }


        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        return totalWeight;
    }


}
