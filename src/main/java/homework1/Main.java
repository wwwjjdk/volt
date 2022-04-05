package homework1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyVol myVol = new MyVol();
        Thread thread1 = new Thread(null, myVol::plus, "Человек");
        Thread thread2 = new Thread(null, myVol::check, "Игрушка");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.interrupt();

    }

}
