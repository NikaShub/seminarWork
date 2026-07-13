package FinalPrep_Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConveyorBeltSimulator {
    public static void startFactory(int numProducers, int numConsumers, int maxCapacity, int maxActiveRobots, int totalItemsToProcess) {
        Lock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        Semaphore energySemaphore = new Semaphore(maxActiveRobots);

        Queue<Integer> conveyor = new LinkedList<>();



        Thread[] producers = new Thread[numProducers];
        for (int i = 0; i < numProducers; i++) {
            producers[i] = new Thread(() -> {
                while(true) {
                    lock.lock();
                    try {
                        if (totalItemsToProcess == 0) break;

                        while(conveyor.size() == maxCapacity) {
                            try {
                                notFull.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (totalItemsToProcess == 0) break;
                        }
                    } finally {
                        lock.unlock();
                    }

                    try {
                        energySemaphore.acquire();
                        //Chavwerot
                    } catch (InterruptedException e){

                    }
                }
            }
            );
            producers[i].start();
        }
    }
}
