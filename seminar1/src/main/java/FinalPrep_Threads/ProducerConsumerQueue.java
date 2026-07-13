package FinalPrep_Threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerQueue<T> {

    private final Queue<T> queue;
    private final int capacity;

    private final Lock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public ProducerConsumerQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void put(T value) {
        lock.lock();
        try {
            while(queue.size() == capacity) {
                notFull.await();
            }

            queue.add(value);
            notEmpty.signalAll();
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            lock.unlock();
        }
    }

    public T take() {
        T num = null;
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            num = queue.poll();
            notFull.signalAll();
            return num;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
        return num;
    }
}
