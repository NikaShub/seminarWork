package seminar13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class semaphor {
    private int permits;
    private Lock lock;
    private Condition newPermit;

    public semaphor(int permits) {
        this.permits = permits;
        lock = new ReentrantLock();
        newPermit = lock.newCondition();
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        while (permits == 0) newPermit.await();
        permits--;
        lock.unlock();
    }

    public void release() {
        lock.lock();
        permits++;
        newPermit.signalAll();
        lock.unlock();
    }
}
