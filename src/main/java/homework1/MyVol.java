package homework1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyVol extends Thread {
    public static final int SIZE = 2;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void plus() {
        for (int i = 0; i < SIZE; i++) {
            if (atomicInteger.get() == 0) {
                System.out.printf("%s включает тумблер\n", Thread.currentThread().getName());
                atomicInteger.getAndIncrement();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void check() {
        while (!isInterrupted()) {
            if (atomicInteger.get() == 1) {
                System.out.printf("%s выключает тумблер\n", Thread.currentThread().getName());
                atomicInteger.getAndDecrement();
            }

        }
    }
}


