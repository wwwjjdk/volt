package homework2;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class MyRunable /*implements Runnable*/ {
    //todo можно метод засунуть в ран, но тогда нужно переопределить конструктор, смысл остается тем же
    ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);
    LongAdder longAdder = new LongAdder();

    public void somethingDoing(int[] i) {
        System.out.printf("%s начинает работу\n", Thread.currentThread().getName());
        count.set(count.get() + Arrays.stream(i).sum());
        longAdder.add(Arrays.stream(i).sum());
        System.out.printf("%s -> %d\n", Thread.currentThread().getName(), count.get());
    }
    public long longAdderSum(){
        return longAdder.sum();
    }
}
