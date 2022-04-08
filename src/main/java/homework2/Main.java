package homework2;

import java.util.Arrays;

public class Main {
    public static final int SIZE = 5;
    public static final int COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        MyRunable myRunable = new MyRunable();
        for (int i = 1; i <= COUNT; i++) {
            new Thread(null, () -> myRunable.somethingDoing(createArray()), "Поток "+i).start();
        }
        Thread.sleep(200);
        System.out.printf("   ^^^^\n\t%s\n   ^^^^",myRunable.longAdderSum());
    }

    public static int[] createArray() {
        int[] array = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(Math.random() * 10);
        }
        System.out.printf("%s -> %d\n",Arrays.toString(array), Arrays.stream(array).sum());
        return array;
    }
}
