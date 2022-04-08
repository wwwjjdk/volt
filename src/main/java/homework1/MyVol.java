package homework1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MyVol extends Thread {
    private static final int SIZE = 2;
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public void plus() {
        for (int i = 0; i < SIZE; i++) {
            if (atomicBoolean.get() == false) {
                System.out.printf("%s включает тумблер\n", Thread.currentThread().getName());
                atomicBoolean.set(true);
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
            if (atomicBoolean.get() == true) {
                System.out.printf("%s выключает тумблер\n", Thread.currentThread().getName());
                atomicBoolean.set(false);
            }

        }
    }
}


