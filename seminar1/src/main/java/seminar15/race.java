package seminar15;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class race{



    private static class Racer extends Thread {
             private int id;
             private CyclicBarrier startLatch;
             private CountDownLatch finishLatch;
             private List<Integer> order;

             public Racer(int id, CyclicBarrier startLatch, CountDownLatch finishLatch, List<Integer> order) {
                 this.id = id;
                 this.startLatch = startLatch;
                 this.finishLatch = finishLatch;
                 this.order = order;
             }

             @Override
             public void run() {
                 try {
                     sleep(5); // warmup
                     System.out.println("warming up " + id);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 try {
                     startLatch.await();
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 } catch (BrokenBarrierException e) {
                     throw new RuntimeException(e);
                 }


                 order.add(id);
                 finishLatch.countDown();
             }
        }

        public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
            CyclicBarrier startLatch = new CyclicBarrier(10 + 1);
            CountDownLatch finishLatch = new CountDownLatch(10); // is raodenoba rac aris racerebi aq main aalodeba

            startLatch.await();
            finishLatch.await();
            System.out.println("Race Finished");
        }

}
